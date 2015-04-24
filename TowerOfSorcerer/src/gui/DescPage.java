package gui;

import items.Items;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DescPage extends JPanel {

	private JTextField name;
	private JTextArea description;
	
	public DescPage(Items item) {
		JPanel namePanel = new JPanel();
		if (item == null)
			name = new JTextField();
		else
			name = new JTextField(item.getName());
		JLabel nameL = new JLabel("Name: ");
		namePanel.add(nameL);
		namePanel.add(name);
		name.setEditable(false);
		
		JPanel descriptionPanel = new JPanel();
		if (item == null)
			description = new JTextArea();
		else
			description = new JTextArea(item.getDescription());
		JLabel descriptionL = new JLabel("Description: ");
		descriptionPanel.add(descriptionL);
		descriptionPanel.add(description);
		description.setEditable(false);
				
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(namePanel);
		add(descriptionPanel);
		setVisible(true);
	}
	

}
