package com.sirma.itt.javacourse.chatapp;


/**
 * @author Ventsislav Marinov
 */
public class ChatGUIFactory {
	public ChatGUI getChatGUI(String guiLanguage, ClientLogic clientLogic) {
		if (guiLanguage.equals(null)) {
			return null;
		}
		if (guiLanguage.equalsIgnoreCase("BULGARIAN")) {
			return new BulgarianChatWindow(clientLogic);
		}
		if (guiLanguage.equalsIgnoreCase("ENGLISH")) {
			return new EnglishChatWindow(clientLogic);
		}
		return null;
	}
}
