package com.sirma.itt.javacourse.chatapp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Implements the login screen of the chat application.
 * 
 * @author Ventsislav Marinov
 */
public class LoginScreen implements ActionListener, ItemListener {
	// login button
	private JButton login;
	// nickname field
	private JTextField nicknameField;
	// login window
	private JFrame loginWindow;
	// language options
	private JRadioButton languageEN;
	private JRadioButton languageBG;
	private JLabel nickname;
	// flag for language change
	private boolean languageSwapped = false;
	// chat client logic
	private ClientLogic clientLogic;

	/*
	 * Used for message dialogs.
	 */
	public static final int SERVER_UNREACHABLE = 0;
	public static final int CONNECTION_ATTEMPT = 1;
	public static final int NICKNAME_TAKEN = 2;
	public static final int CONNECTED = 3;
	public static final int SERVER_CONNECTION_LIMIT_REACHED = 4;

	/**
	 * Adds client logic to the login screen.
	 * 
	 * @param clientLogic
	 */
	public void addClientLogic(ClientLogic clientLogic) {
		this.clientLogic = clientLogic;
	}

	/**
	 * Creates and opens the login screen.
	 */
	public void createAndShowLoginWindow() {
		loginWindow = new JFrame("Login screen");
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.setLayout(new BorderLayout());
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		loginWindow.add(northPanel, BorderLayout.NORTH);
		loginWindow.add(southPanel, BorderLayout.SOUTH);
		loginWindow.add(centerPanel, BorderLayout.CENTER);
		ButtonGroup btnGroup = new ButtonGroup();
		languageBG = new JRadioButton("Bulgarian", false);
		languageBG.addItemListener(this);
		languageEN = new JRadioButton("English", true);
		languageEN.addItemListener(this);
		btnGroup.add(languageBG);
		btnGroup.add(languageEN);
		centerPanel.add(languageBG);
		centerPanel.add(languageEN);
		nickname = new JLabel("Nickname:");
		northPanel.add(nickname);
		nicknameField = new JTextField(15);
		northPanel.add(nicknameField);
		login = new JButton("Login");
		login.setActionCommand("login");
		login.addActionListener(this);
		southPanel.add(login);

		loginWindow.setLocationRelativeTo(null);
		loginWindow.setResizable(false);
		loginWindow.pack();
		loginWindow.setVisible(true);
	}

	/**
	 * Used to show message dialogs on connection attempts.
	 * 
	 * @param reason
	 *            reason for call
	 */
	public void connectionMessageDialogs(int reason) {
		// holds the error message
		String error = "";
		// holds information message
		String message = "";
		/*
		 * If language is swapped sets messages to Bulgarian, otherwise sends them in English.
		 */
		if (languageSwapped) {
			switch (reason) {
				case NICKNAME_TAKEN:
					message = "Вече има потребител с този прякор";
					error = "Достъп  отказан";
					break;
				case CONNECTION_ATTEMPT:
					message = "Връзката е неуспешна. Нов опит след 2 секунди.";
					break;
				case SERVER_UNREACHABLE:
					message = "Няма връзка със сървъра";
					error = "Прекратяване на връзката";
					break;
				case CONNECTED:
					message = "Връзката със сървъра е успешна";
					break;
			}
		} else {
			switch (reason) {
				case NICKNAME_TAKEN:
					message = "This nickname is taken.";
					error = "Connection refused";
					break;
				case CONNECTION_ATTEMPT:
					message = "Cannot find host. Connection retry in 2 seconds.";
					break;
				case SERVER_UNREACHABLE:
					message = "Connection unreachable.";
					error = "Connection closed";
					break;
				case CONNECTED:
					message = "Connected";
					break;
			}
		}
		if (reason == NICKNAME_TAKEN)
			JOptionPane.showMessageDialog(loginWindow, message, error, JOptionPane.WARNING_MESSAGE);
		if (reason == CONNECTION_ATTEMPT) {
			JOptionPane.showMessageDialog(loginWindow, message);

		}
		if (reason == SERVER_UNREACHABLE) {
			JOptionPane.showMessageDialog(loginWindow, message, error, JOptionPane.ERROR_MESSAGE);
		}
		if (reason == CONNECTED) {
			JOptionPane.showMessageDialog(loginWindow, message);
		}
	}

	/**
	 * Changes language of the login screen.
	 * 
	 */
	public void changeLanguage() {
		/*
		 * Translates login screen
		 */
		if (languageSwapped) {
			loginWindow.setTitle("Вход");
			login.setText("Влез");
			languageEN.setText("Английски");
			languageBG.setText("Български");
			nickname.setText("Прякор: ");
			loginWindow.pack();
		} else {
			loginWindow.setTitle("Login screen");
			login.setText("Login");
			languageEN.setText("English");
			languageBG.setText("Bulgarian");
			nickname.setText("Nickname: ");
			loginWindow.pack();
		}

	}

	public void setLoginButtonEnabled(boolean enable) {
		login.setEnabled(enable);
	}

	/**
	 * Returns inputed nickname in the nickname field.
	 * 
	 * @return inputed nickname
	 */
	public String getNickname() {
		return nicknameField.getText();
	}

	/**
	 * Opens the chat window. If language is swapped creates a Bulgarian chat window, otherwise
	 * opens the English one.
	 */
	public void openChatWindow() {
		ChatGUIFactory chatGUIFactory = new ChatGUIFactory();
		if (languageSwapped) {
			ChatGUI chatGUI = chatGUIFactory.getChatGUI("BULGARIAN", clientLogic);
			chatGUI.createAndOpenChatWindow();
			clientLogic.addChatGUI(chatGUI);
		} else {
			ChatGUI chatGUI = chatGUIFactory.getChatGUI("ENGLISH", clientLogic);
			chatGUI.createAndOpenChatWindow();
			clientLogic.addChatGUI(chatGUI);
		}

	}

	/**
	 * Closes login screen.
	 */
	public void closeLoginScreen() {
		loginWindow.setVisible(false);
		loginWindow.dispose();
	}

	public void itemStateChanged(ItemEvent ie) {
		Object source = ie.getItem();
		if (source.equals(languageBG)) {
			languageSwapped = true;
			changeLanguage();
		}
		if (source.equals(languageEN)) {
			languageSwapped = false;
			changeLanguage();
		}

	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("login")) {
			if (!nicknameField.getText().equals("") && !nicknameField.getText().contains("[")
					&& !nicknameField.getText().contains("]")) {
				clientLogic.connectToServer(nicknameField.getText());
			} else {
				if (languageSwapped) {
					JOptionPane.showMessageDialog(loginWindow,
							"Не е въведено потребителско име или има грешни символи. \n"
									+ "'[' и ']' не са позволени", "Грешно въведени данни",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(loginWindow,
							"No nickname specified or contains illegal characters. \n"
									+ "'[' and ']' are not allowed", "Wrong input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

}
