package com.sirma.itt.javacourse.chatapp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;

/**
 * Implements the communication rules between the server and the client of the chat application.
 * 
 * @author Ventsislav Marinov
 */
public class ClientServerProtocol {
	private ServerLogic serverLogic;
	private ServerGUI serverGUI;
	// used to execute commands from the server
	private ServerCommandExecutor serverCommandExecutor;
	// used to add users to server's connected users list
	private AddUserCommand addUser;
	// used to remove users from server's connected users list
	private RemoveUserCommand removeUser;
	// used to send message to connected users
	private SendMessageCommand sendMessage;
	/*
	 * Messages sent from server on specific events.
	 */
	public final static String WELCOME_MESSAGE = "Welcome";
	public final static String SERVER_CLOSING = "cls";
	public final static String NICKNAME_IN_USE = "used";
	public final static String ADD_USER = "add";
	public final static String REMOVE_USER = "rmv";
	public final static String CONNECTION_LIMIT_REACHED = "limit";
	public final static String DISCONNECTING_FROM_SERVER = "dc";
	public final static String ATTEMPT_CONNECTION = "atmpt";

	public ClientServerProtocol(ServerLogic serverLogic, ServerGUI serverGUI) {
		this.serverLogic = serverLogic;
		this.serverGUI = serverGUI;
		serverCommandExecutor = new ServerCommandExecutor();
		addUser = new AddUserCommand(serverLogic);
		removeUser = new RemoveUserCommand(serverLogic);
		sendMessage = new SendMessageCommand(serverLogic);
	}

	/**
	 * Processes input from the client.
	 * 
	 * @param message
	 *            input from the client.
	 */
	public void processInput(String message) {
		String tempNickname;
		SimpleDateFormat date = new SimpleDateFormat("hh:mm:ss");
		Calendar cal = new GregorianCalendar();
		/*
		 * If client attempts to connect, server checks nickname availability. If client is
		 * accepted, sends "welcome message" and adds him to the clients lists, otherwise informs
		 * that nickname is in use.
		 */
		if (message.contains(ATTEMPT_CONNECTION)) {
			// writes on server status field about connection attempt
			serverGUI.setStatusText(date.format(cal.getTime()) + " Connection attempt.");
			// determines nickname inputed
			tempNickname = message.substring(5, message.length());
			/*
			 * if nickname is available, sends welcome message, adds user to clients lists and
			 * informs him for online users atm.
			 */
			if (serverLogic.nicknameAvailable(tempNickname)) {
				serverCommandExecutor.getCommand(addUser);
				serverCommandExecutor.executeCommand(tempNickname.toLowerCase());
				serverCommandExecutor.getCommand(sendMessage);
				serverCommandExecutor.executeCommand(tempNickname, WELCOME_MESSAGE + " "
						+ tempNickname);

				/*
				 * informs client about online users. Sends message "add " and the nickname to be
				 * added to the online users list.
				 */
				for (String s : serverLogic.getConnectedUsersByName()) {
					serverCommandExecutor.getCommand(sendMessage);
					serverCommandExecutor.executeCommand(tempNickname, ADD_USER + s);
				}

				// writes to server status field about the connected user
				serverGUI.setStatusText(date.format(cal.getTime()) + " " + tempNickname
						+ " connected.");
				// shows all connected users in the server status field
				serverGUI.setStatusText(date.format(cal.getTime()) + " Connected clients: "
						+ serverLogic.getConnectedUsersByName().toString());
				/*
				 * Iterates the connected clients list and sends message to everyone.
				 */
				Iterator it = serverLogic.getConnectedUsers().entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pairs = (Map.Entry) it.next();
					// sends message to chat, announcing the newly connected user
					serverCommandExecutor.getCommand(sendMessage);
					serverCommandExecutor.executeCommand(pairs.getKey().toString(), tempNickname
							+ " joined.");
					/*
					 * sends message to connected clients, to add the new user to their online users
					 * list
					 */
					serverCommandExecutor.executeCommand(pairs.getKey().toString(), ADD_USER
							+ tempNickname);
				}
				/*
				 * if nickname is in use sends error message, and writes to server status screen
				 * about invalid connection.
				 */
			} else {
				serverCommandExecutor.getCommand(sendMessage);
				serverCommandExecutor.executeCommand(NICKNAME_IN_USE);
				serverGUI.setStatusText(date.format(cal.getTime()) + "Invalid nickname.");
			}
			/*
			 * When client terminates connection, informs all users in chat. Sends message to
			 * clients to remove user from their online users list. Server removes client from
			 * clients lists.
			 */
		} else if (message.contains(DISCONNECTING_FROM_SERVER)) {
			tempNickname = message.substring(2, message.length());
			// server removes client from client list
			serverCommandExecutor.getCommand(removeUser);
			serverCommandExecutor.executeCommand(tempNickname);

			Iterator it = serverLogic.getConnectedUsers().entrySet().iterator();
			/*
			 * Sends message in chat, announcing that user<nickname> left the chat. Sends message
			 * for removal of the client from the online users list.
			 */
			while (it.hasNext()) {
				Map.Entry pairs = (Map.Entry) it.next();
				serverCommandExecutor.getCommand(sendMessage);
				serverCommandExecutor.executeCommand(pairs.getKey().toString(), tempNickname
						+ " left.");
				serverCommandExecutor.executeCommand(pairs.getKey().toString(), REMOVE_USER
						+ tempNickname);
			}
			serverGUI.setStatusText(date.format(cal.getTime()) + " " + tempNickname
					+ " disconnected.");
			serverGUI.setStatusText(date.format(cal.getTime()) + " Connected clients: "
					+ serverLogic.getConnectedUsersByName().toString());
			/*
			 * Writes messages in the chat, received from the clients.
			 */
		} else if (!message.equals(ATTEMPT_CONNECTION)
				&& !message.equals(DISCONNECTING_FROM_SERVER)) {

			// print message from user to chat
			Iterator it = serverLogic.getConnectedUsers().entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pairs = (Map.Entry) it.next();
				serverCommandExecutor.getCommand(sendMessage);
				serverCommandExecutor.executeCommand(pairs.getKey().toString(), message);
			}

		}
	}

}
