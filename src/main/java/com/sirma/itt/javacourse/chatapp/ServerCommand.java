package com.sirma.itt.javacourse.chatapp;

/**
 * Used to implement commands executed by the server.
 * 
 * @author Ventsislav Marinov
 */
public interface ServerCommand {
	void execute(String text);

	void execute(String nickname, String message);
}
