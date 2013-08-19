package com.sirma.itt.javacourse.chatapp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * Implements the chat window for Bulgarian users.
 * 
 * @author Ventsislav Marinov
 */
public class BulgarianChatWindow extends JFrame implements ChatGUI, ActionListener, KeyListener {
	private ClientLogic clientLogic;
	// text area that holds sent messages
	private JTextArea response;
	// text field for user input
	private JTextField answer;
	// text area that holds nicknames of all online users
	private JTextArea onlineUsers;
	// end session button
	private JButton endSession;
	// send button
	private JButton send;

	private int ALLOWED_MESSAGE_LENGTH = 100;

	public static final String SERVER_CLOSING = "cls";

	public BulgarianChatWindow(ClientLogic clientLogic) {
		this.clientLogic = clientLogic;
	}

	public void createAndOpenChatWindow() {
		setTitle("Чат");
		setSize(250, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				clientLogic.disconnectFromServer();
				setVisible(false);
				dispose();
			}
		});
		setLayout(new BorderLayout());

		JPanel southPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel eastPanel = new JPanel();

		add(southPanel, BorderLayout.SOUTH);
		add(centerPanel, BorderLayout.CENTER);
		add(eastPanel, BorderLayout.EAST);

		response = new JTextArea(20, 40);
		response.setEditable(false);
		response.setLineWrap(true);
		response.setWrapStyleWord(true);

		JScrollPane responsePane = new JScrollPane(response,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		centerPanel.add(responsePane);

		answer = new JTextField(20);
		answer.setToolTipText("type your message here");
		answer.addKeyListener(this);
		southPanel.add(answer);

		send = new JButton("Изпрати");
		send.setActionCommand("send");
		send.addActionListener(this);
		southPanel.add(send);

		endSession = new JButton("Край на сесията");
		endSession.setActionCommand("end");
		endSession.addActionListener(this);
		southPanel.add(endSession);
		onlineUsers = new JTextArea("Online users: \n", 20, 10);
		onlineUsers.setEditable(false);
		onlineUsers.setWrapStyleWord(true);
		onlineUsers.setLineWrap(true);

		JScrollPane onlinePane = new JScrollPane(onlineUsers,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		eastPanel.add(onlinePane);
		setLocationRelativeTo(null);
		setResizable(false);
		pack();
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("send")) {
			if (!answer.getText().equals("")) {
				if (answer.getText().length() > 100) {
					String message = answer.getText().substring(0, 100);
					clientLogic.sendMessageToChat(message);
				} else {
					clientLogic.sendMessageToChat(answer.getText());
				}
				answer.setText("");
				if (!answer.isEditable()) {
					answer.setEditable(true);
				}
			}
		}
		if (cmd.equals("end")) {
			clientLogic.disconnectFromServer();
			setVisible(false);
			dispose();
		}

	}

	public void updateUsersOnlineField() {
		onlineUsers.setText("Потребители на линия: \n");
		HashSet<String> temp = clientLogic.getOnlineUsersList();
		Iterator<String> it = temp.iterator();
		while (it.hasNext()) {
			onlineUsers.append(it.next() + "\n");
		}

	}

	/**
	 * Prints messages to the response field. {@inheritDoc}
	 */
	public void showMessageInChat(String message) {
		response.append(message + "\n");
	}

	/**
	 * Disposes the chat window. {@inheritDoc}
	 */
	public void closeChat() {
		// TODO Auto-generated method stub
		setVisible(false);
		dispose();

	}


	/**
	 * Opens message dialogs on set events. {@inheritDoc}
	 */
	public void showMessageDialog(String reason) {
		if (reason == SERVER_CLOSING) {
			JOptionPane.showMessageDialog(this, "Сървърът е спрян", "Спиране на сървъра",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Used to obtain the text in the response field. Invoked by saveChatHistory(). {@inheritDoc}
	 */
	public String[] getChatHistory() {
		String[] lines = response.getText().split("\t\r\n");
		return lines;
	}

	public void keyTyped(KeyEvent e) {
		int key = e.getKeyCode();
		if (answer.getText().length() >= ALLOWED_MESSAGE_LENGTH) {
			answer.setEditable(false);
		} else {
			answer.setEditable(true);
		}
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			if (!answer.getText().equals("")) {
				if (answer.getText().length() > 100) {
					String message = answer.getText().substring(0, 100);
					clientLogic.sendMessageToChat(message);
				} else {
					clientLogic.sendMessageToChat(answer.getText());
				}
				answer.setText("");
				if (!answer.isEditable()) {
					answer.setEditable(true);
				}
			}
		}
		if (key == KeyEvent.VK_BACK_SPACE) {
			if (!answer.isEditable()) {
				answer.setEditable(true);
			}
		}

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
