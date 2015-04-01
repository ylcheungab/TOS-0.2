package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPage extends JDialog implements ActionListener {

	private JButton NewButton;
	private JButton LoadButton;

	public StartPage() {
		setTitle("Start Options");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// the panel divided into five parts(east, north, south, west, center)
		// north part
		String startmsg = "This is Tower of Sorcerer ver. 1.0. " + "\n"
				+ "Please choose one of the options:";
		JLabel intromsg = new JLabel(startmsg);

		// center part is a panel, panel with buttons
		JPanel ButtonPanel = new JPanel();

		NewButton = new JButton("New game");
		NewButton.addActionListener(this);
		ButtonPanel.add(NewButton);

		LoadButton = new JButton("Load game");
		LoadButton.addActionListener(this);
		ButtonPanel.add(LoadButton);

		// packing
		getContentPane().add(BorderLayout.NORTH, intromsg);
		getContentPane().add(BorderLayout.CENTER, ButtonPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent But) {
		if (But.getSource() == NewButton) {
			ContentPage main = new ContentPage();
			dispose();
		} else if (But.getSource() == LoadButton) {

		}
	}

}
