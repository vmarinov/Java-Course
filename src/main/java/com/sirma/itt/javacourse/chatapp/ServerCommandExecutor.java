package com.sirma.itt.javacourse.chatapp;


/**
 * Implements a command executor for the @ServerLogic
 * 
 * @author Ventsislav Marinov
 */
public class ServerCommandExecutor {
	private ServerCommand cmd;

	public void getCommand(ServerCommand cmd) {
		this.cmd = cmd;
	}

	public void executeCommand(String text) {
		cmd.execute(text);
	}

	public void executeCommand(String nickname, String message) {
		cmd.execute(nickname, message);
	}
}
