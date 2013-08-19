package com.sirma.itt.javacourse.chatapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Implements server threads, for client connections.
 * 
 * @author Ventsislav Marinov
 */
public class ServerThreads extends Thread {
	private ServerLogic serverLogic;
	private BufferedReader serverInput;
	private PrintWriter serverOutput;
	private Socket clientSocket;
	private ServerGUI serverGUI;
	// holds nickname of the connected client
	private String nickname;
	// holds messages sent
	private String inputLine;

	public ServerThreads(ServerLogic serverLogic, Socket clientSocket, ServerGUI serverGUI) {
		this.serverLogic = serverLogic;
		this.clientSocket = clientSocket;
		this.serverGUI = serverGUI;
	}

	public void run() {
		try {
			serverInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			serverOutput = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((inputLine = serverInput.readLine()) != null) {
				ClientServerProtocol clientServerProtocol = new ClientServerProtocol(serverLogic,
						serverGUI);
				clientServerProtocol.processInput(inputLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Used to send messages to the connected user.
	 * 
	 * @param message
	 */
	public void sendMessageToUser(String message) {
		serverOutput.println(message);
	}

	public String getNickname() {
		return nickname;
	}

	/**
	 * Closes the connection. Sends message to user, informing about connection termination. Closes
	 * I/O streams and client socket.
	 */
	public void closeConnection() {
		serverOutput.println(ClientServerProtocol.SERVER_CLOSING);
		if (serverOutput != null) {
			serverOutput.close();
		}
		if (serverInput != null) {
			try {
				serverInput.close();
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
}
