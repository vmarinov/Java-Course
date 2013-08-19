package com.sirma.itt.javacourse.chatapp;


/**
 * Implements send message command.
 * 
 * @author Ventsislav Marinov
 */
public class SendMessageCommand implements ServerCommand {
	private ServerLogic serverLogic;

	public SendMessageCommand(ServerLogic serverLogic) {
		this.serverLogic = serverLogic;
	}

	public void execute(String message) {
		serverLogic.getCurrentThread().sendMessageToUser(message);
	}

	public void execute(String nickname, String message) {
		// TODO Auto-generated method stub
		serverLogic.getUser(nickname).sendMessageToUser(message);
	}

}
