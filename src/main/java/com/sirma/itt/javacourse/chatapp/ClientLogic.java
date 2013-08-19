package com.sirma.itt.javacourse.chatapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

import javax.swing.SwingUtilities;

/**
 * Implements the client logic of the chat application.
 * 
 * @author Ventsislav Marinov
 */
public class ClientLogic {
	private Socket clientSocket;
	private BufferedReader clientInput;
	private PrintWriter clientOutput;
	// nickname of the user
	private String nickname;
	// used for creating and opening the login screen
	private LoginScreen loginScreen;
	// connection status with server
	private boolean connected = false;
	// used for creating and opening the chat room
	private ChatGUI chatGui;
	// constant for maximum connection attempts
	private final int MAX_CONNECTION_ATTEMPTS = 3;
	// number of connection attempts
	private int numberOfConnectionAttempts = 0;
	// holds the nicknames of the online users in chat
	private HashSet<String> onlineUsers = new HashSet<String>();
	// used to hold messages sent from the server
	private String fromServer;
	// true if nickname isn't in use and user is allowed to join chat
	private boolean accepted = false;

	public ClientLogic(LoginScreen loginScreen) {
		this.loginScreen = loginScreen;
	}

	public static void main(String args[]) {
		final LoginScreen loginScreen = new LoginScreen();
		final ClientLogic clientLogic = new ClientLogic(loginScreen);
		loginScreen.addClientLogic(clientLogic);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				loginScreen.createAndShowLoginWindow();
			}
		});
	}

	/**
	 * Adds chat GUI.
	 * 
	 * @param chatGUI
	 */
	public void addChatGUI(ChatGUI chatGUI) {
		this.chatGui = chatGUI;
	}

	/**
	 * Used to remove users from the users online list, when they disconnect.
	 * 
	 * @param nickname
	 *            the nickname to be removed
	 */
	public void removeUserfromList(String nickname) {
		onlineUsers.remove(nickname);
	}

	/**
	 * Used to add users to the users online list, when they connect to chat.
	 * 
	 * @param nickname
	 *            the nickname to be added
	 */
	public void addUserToList(String nickname) {
		onlineUsers.add(nickname);
	}

	/**
	 * Creates the client socket and attempts to connect to the server. If connection fails,
	 * attempts to reconnect (MAX_CONNECTION_ATTEMPTS) times. Shows message dialogs indicating the
	 * status of connection. If connection is established sends login information to the server.
	 * 
	 * @throws IOException
	 */
	private void createSocket() throws IOException {
		numberOfConnectionAttempts++;
		try {

			clientSocket = new Socket("localhost", 7000);
			clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			clientOutput = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (UnknownHostException e) {
			loginScreen.connectionMessageDialogs(LoginScreen.CONNECTION_ATTEMPT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			loginScreen.connectionMessageDialogs(LoginScreen.CONNECTION_ATTEMPT);
			e.printStackTrace();
		}
		if (clientSocket != null) {
			connected = true;
			clientOutput.println(ClientServerProtocol.ATTEMPT_CONNECTION
					+ loginScreen.getNickname().toLowerCase());
		}
	}

	/**
	 * Sets nickname for the client, locks login button and attempts to connect to the server by
	 * invoking createSocket(). If connection to the server isn't established unlocks the login
	 * button. On successful connection starts listening for messages from the server.
	 * 
	 * @param nickname
	 */
	public void connectToServer(String nickname) {
		numberOfConnectionAttempts = 0;
		// sets nickname
		this.nickname = nickname;
		// locks the login button until all connection attempts have passed
		loginScreen.setLoginButtonEnabled(false);
		Thread clientThread = new Thread(new Runnable() {
			public void run() {
				try {
					while (!connected && numberOfConnectionAttempts < MAX_CONNECTION_ATTEMPTS) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						createSocket();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!connected) {
					loginScreen.connectionMessageDialogs(LoginScreen.SERVER_UNREACHABLE);
					loginScreen.setLoginButtonEnabled(true);
				}

				while (connected) {
					waitForMessages();
				}

			}
		});
		clientThread.start();
	}

	/**
	 * Used to disconnect from the server. Closes I/O streams, sockets and invokes
	 * saveChatHistory().
	 */
	public void disconnectFromServer() {
		SimpleDateFormat date = new SimpleDateFormat("MM-dd-YYYY");
		Calendar cal = new GregorianCalendar();

		connected = false;
		accepted = false;
		saveChatHistory(date.format(cal.getTime()));
		chatGui.closeChat();
		if (clientOutput != null) {
			clientOutput.println(ClientServerProtocol.DISCONNECTING_FROM_SERVER + nickname);
			clientOutput.close();
		}
		if (clientInput != null) {
			try {
				clientInput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Used for communication with the server. Sets rules on when to add/remove users from list,
	 * conditions on connection acceptance and used to follow server's status.
	 */
	private void waitForMessages() {
		try {
			while ((fromServer = clientInput.readLine()) != null) {
				/*
				 * Opens message dialog if server declines connection, when nickname is in use, and
				 * unlocks login button.
				 */
				if (!accepted) {
					if (fromServer.equals(ClientServerProtocol.NICKNAME_IN_USE)) {
						loginScreen.connectionMessageDialogs(LoginScreen.NICKNAME_TAKEN);
						loginScreen.setLoginButtonEnabled(true);
						connected = false;
						/*
						 * Closes login screen if server accepted connection, and opens the chat
						 * window. Sets accepted flag to true.
						 */
					} else if (fromServer.contains(ClientServerProtocol.WELCOME_MESSAGE)) {
						accepted = true;
						loginScreen.connectionMessageDialogs(LoginScreen.CONNECTED);
						loginScreen.closeLoginScreen();
						loginScreen.openChatWindow();
					}

				}
				/*
				 * Receives these messages only if connection is accepted.
				 */
				if (accepted) {
					String tempNickname;
					/*
					 * When server shuts down, sends message to client. Upon receiving it the client
					 * invokes disconnectFromServer().
					 */
					if (fromServer.equals(ClientServerProtocol.SERVER_CLOSING)) {
						chatGui.showMessageDialog(ClientServerProtocol.SERVER_CLOSING);
						disconnectFromServer();
						/*
						 * When new user connects to chat, the server informs all connected users
						 * with a message. Client then invokes the addUserToList() to store the
						 * nickname of the connected user. After the user is added
						 * updateUsersOnlineField() is called.
						 */
					} else if (fromServer.contains(ClientServerProtocol.ADD_USER)) {
						tempNickname = fromServer.substring(3, fromServer.length());
						addUserToList(tempNickname);
						chatGui.updateUsersOnlineField();
						/*
						 * When a user disconnects from chat, all connected users are informed with
						 * this message. Client invokes removeUserFromList() to remove the
						 * disconnected user's nickname. After removal, updates the online users in
						 * the chat window by invoking updateUsersOnlineField().
						 */
					} else if (fromServer.contains(ClientServerProtocol.REMOVE_USER)) {
						tempNickname = fromServer.substring(3, fromServer.length());
						removeUserfromList(tempNickname);
						chatGui.updateUsersOnlineField();

						/*
						 * If the message received from the server isn't a condition message, client
						 * invokes showMessageInChat().
						 */
					} else {
						chatGui.showMessageInChat(fromServer);
					}
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("No IO for server socket.");
			e.printStackTrace();

		}
	}

	/**
	 * Used to send messages to chat. Capitalizes the first letter of the message, adds time stamp
	 * and shows the nickname of the sender.
	 * 
	 * @param message
	 */
	public void sendMessageToChat(String message) {
		StringBuilder sb = new StringBuilder(message.length());
		/*
		 * Capitalizes first letter in the message.
		 */
		sb.append(Character.toUpperCase(message.charAt(0)));
		sb.append(message.substring(1, message.length()));
		String formatedMessage = "["
				+ (new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime())) + "]"
				+ " " + nickname + ": " + sb;
		clientOutput.println(formatedMessage);
	}

	/**
	 * Saves chat history to a text file.
	 * 
	 * @param fileName
	 *            the name of the file
	 */
	private void saveChatHistory(String fileName) {
		String directory = "src\\main\\resources\\";
		String[] log = chatGui.getChatHistory();

		File saveFile = new File(directory + fileName + ".txt");
		try {

			BufferedWriter fileWritter = new BufferedWriter(new FileWriter(saveFile, true));
			for (String s : log) {
				fileWritter.write(s + "\r\n");
			}

			fileWritter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean connectedToServer() {
		return connected;
	}

	public HashSet<String> getOnlineUsersList() {
		return onlineUsers;
	}
}
