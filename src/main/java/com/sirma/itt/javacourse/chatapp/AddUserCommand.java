package com.sirma.itt.javacourse.chatapp;


/**
 * Implements the add user command.
 * 
 * @author Ventsislav Marinov
 */
public class AddUserCommand implements ServerCommand {
	private ServerLogic serverLogic;

	public AddUserCommand(ServerLogic serverLogic) {
		this.serverLogic = serverLogic;
	}

	public void execute(String nickname) {
		// TODO Auto-generated method stub
		serverLogic.addUserToList(nickname);
	}

	public void execute(String nickname, String message) {
		// TODO Auto-generated method stub

	}

}
