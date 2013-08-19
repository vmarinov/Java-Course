package com.sirma.itt.javacourse.chatapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.SwingUtilities;

/**
 * Implements the server logic of the chat application.
 * 
 * @author Ventsislav Marinov
 */
public class ServerLogic {
	// stores the connected clients
	private HashMap<String, ServerThreads> connectedUsersList = new HashMap<String, ServerThreads>();
	private ServerSocket serverSocket;
	// used to open new thread for every connection
	private ServerThreads serverThreads;
	// used to create and open the server GUI
	private ServerGUI serverGUI;
	// if false server stops listening for connections
	private boolean listen = true;

	public ServerLogic(ServerGUI serverGUI) {
		this.serverGUI = serverGUI;
	}

	public static void main(String args[]) {
		final ServerGUI serverGUI = new ServerGUI();
		final ServerLogic serverLogic = new ServerLogic(serverGUI);
		serverGUI.addServerLogic(serverLogic);


		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				serverGUI.createAndShowLoginScreen();
			}
		});
		Thread serverThread = new Thread(new Runnable() {
			public void run() {
				serverLogic.startServer();
				while (serverLogic.isListeningForConnections()) {
					serverLogic.acceptConnections();
				}
			}
		});
		serverThread.start();
	}

	/**
	 * Creates the server socket.
	 */
	private void startServer() {
		try {
			serverSocket = new ServerSocket(7000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Used to add connected user to the list.
	 * 
	 * @param nickname
	 *            nickname of the connected user
	 */
	public void addUserToList(String nickname) {
		connectedUsersList.put(nickname, serverThreads);
	}

	/**
	 * Used to remove disconnected users from list.
	 * 
	 * @param nickname
	 *            nickname of the disconnected user
	 */
	public void removeUserFromList(String nickname) {

		connectedUsersList.remove(nickname);

	}

	/**
	 * Used to check if user with this nickname is already connected.
	 * 
	 * @param nickname
	 *            the nickname to be checked
	 * @return true if nickname is available;
	 */
	public boolean nicknameAvailable(String nickname) {
		if (connectedUsersList.containsKey(nickname)) {
			return false;
		}
		return true;
	}

	/**
	 * Used to accept client connections. Opens a new thread for every connection.
	 */
	private void acceptConnections() {
		try {
			serverThreads = new ServerThreads(this, serverSocket.accept(), serverGUI);
			serverThreads.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isListeningForConnections() {
		return listen;
	}

	public ServerThreads getUser(String nickname) {
		return connectedUsersList.get(nickname);
	}

	public Set<String> getConnectedUsersByName() {
		Set<String> names = connectedUsersList.keySet();
		return names;
	}

	public HashMap<String, ServerThreads> getConnectedUsers() {
		return connectedUsersList;
	}

	public ServerThreads getCurrentThread() {
		return serverThreads;
	}

	/**
	 * Used to shutdown the server. Prints message in the server status field, and informs all
	 * connected users.
	 */
	public void serverShutdown() {
		listen = false;
		serverGUI.setStatusText("Server connections closed. Server shut down.");
		if (connectedUsersList != null) {
			Iterator it = connectedUsersList.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pairs = (Map.Entry) it.next();
				getUser(pairs.getKey().toString()).closeConnection();
			}
		}
		connectedUsersList.clear();
		try {
			if (serverSocket != null) {
				serverSocket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
