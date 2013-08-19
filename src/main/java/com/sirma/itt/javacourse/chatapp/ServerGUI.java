package com.sirma.itt.javacourse.chatapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class ServerGUI extends JFrame implements ActionListener {
	// text area that holds connection status messages
	private JTextArea status;
	// button for server shutdown
	private JButton shutdown;
	// logic for the server GUI
	private ServerLogic serverLogic;

	public void addServerLogic(ServerLogic serverLogic) {
		this.serverLogic = serverLogic;
	}
	/**
	 * Creates and opens the server GUI.
	 */
	public void createAndShowLoginScreen() {
		setTitle("Server window.");
		setSize(450, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				serverLogic.serverShutdown();
				setVisible(false);
				dispose();
			}
		});
		JPanel panel = new JPanel();
		add(panel);

		status = new JTextArea("Waiting for connections. \n", 5, 20);
		status.setWrapStyleWord(true);
		status.setLineWrap(true);
		status.setToolTipText("Connection status");
		status.setEditable(false);
		panel.add(status);
		JScrollPane statusPane = new JScrollPane(status,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(statusPane);

		shutdown = new JButton("Shut down");
		shutdown.setActionCommand("shutdown");
		shutdown.addActionListener(this);
		panel.add(shutdown);
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}

	/**
	 * Appends new status message to the connection status field.
	 * 
	 * @param message
	 */
	public void setStatusText(String message) {
		status.append(message + "\n");
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if (cmd.equals("shutdown")) {
			// setVisible(false);
			// dispose();
			serverLogic.serverShutdown();

		}

	}
}
