package com.sirma.itt.javacourse.chatapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ChatGUIFactoryTest {
	@Test
	public void getChatGUITest() {
		LoginScreen loginScreen = new LoginScreen();
		ClientLogic clientLogic = new ClientLogic(loginScreen);
		ChatGUIFactory guiFactory = new ChatGUIFactory();
		ChatGUI chatGUI = guiFactory.getChatGUI("BULGARIAN", clientLogic);
		Assert.assertNotNull(chatGUI);
		chatGUI = guiFactory.getChatGUI("ENGLISH", clientLogic);
		Assert.assertNotNull(chatGUI);
	}
}
