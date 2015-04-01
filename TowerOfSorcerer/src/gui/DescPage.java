package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DescPage extends JPanel implements ActionListener{

	public JTextField name;
	public JTextArea description;
	private JButton EditButton;
	private JButton DeleteButton;
	
	public DescPage() {
		
		JPanel namePanel = new JPanel();
		name = new JTextField("AAA");
		JLabel nameL = new JLabel("Name: ");
		namePanel.add(nameL);
		namePanel.add(name);
		name.setEditable(false);
		
		JPanel descriptionPanel = new JPanel();
		description = new JTextArea();
		JLabel descriptionL = new JLabel("Description: ");
		descriptionPanel.add(descriptionL);
		descriptionPanel.add(description);
		description.setEditable(false);
		
		EditButton = new JButton("Edit");
		EditButton.addActionListener(this);
		
		DeleteButton = new JButton("Delete");
		DeleteButton.addActionListener(this);
				
		setBorder(BorderFactory.createTitledBorder("Description"));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(namePanel);
		add(descriptionPanel);
		add(EditButton);
		add(DeleteButton);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
