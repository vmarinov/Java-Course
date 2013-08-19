package com.sirma.itt.javacourse.chatapp;

import com.sirma.itt.javacourse.chatapp.ServerLogic;

/**
 * Implements the remove user command.
 * 
 * @author Ventsislav Marinov
 */
public class RemoveUserCommand implements ServerCommand {
	private ServerLogic serverLogic;
	
	public RemoveUserCommand(ServerLogic serverLogic) {
		this.serverLogic = serverLogic;
	}
	public void execute(String nickname) {
		// TODO Auto-generated method stub
		serverLogic.removeUserFromList(nickname);
	}

	public void execute(String nickname, String message) {
		// TODO Auto-generated method stub

	}

}
