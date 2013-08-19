package com.sirma.itt.javacourse.chatapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ClientLogicTest {
	
	
	@Test
	public void addUserToListTest() {
		LoginScreen loginScreen = new LoginScreen();
		ClientLogic clientLogic = new ClientLogic(loginScreen);
		loginScreen.addClientLogic(clientLogic);
		clientLogic.addUserToList("hehe");
		org.junit.Assert.assertTrue(clientLogic.getOnlineUsersList().contains("hehe"));
	}

	@Test
	public void removeUserFromListTest() {
		LoginScreen loginScreen = new LoginScreen();
		ClientLogic clientLogic = new ClientLogic(loginScreen);
		loginScreen.addClientLogic(clientLogic);
		clientLogic.addUserToList("hehe");
		org.junit.Assert.assertTrue(clientLogic.getOnlineUsersList().contains("hehe"));
		clientLogic.removeUserfromList("hehe");
		Assert.assertFalse(clientLogic.getOnlineUsersList().contains("hehe"));
	}
	
}
