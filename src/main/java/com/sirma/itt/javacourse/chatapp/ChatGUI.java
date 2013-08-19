package com.sirma.itt.javacourse.chatapp;

/**
 * Used to implement different chat GUI.
 * 
 * @author Ventsislav Marinov
 */
public interface ChatGUI {

	void createAndOpenChatWindow();

	void updateUsersOnlineField();

	void showMessageInChat(String message);

	void closeChat();

	void showMessageDialog(String reason);

	String[] getChatHistory();
}
