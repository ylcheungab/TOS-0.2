package gui;

import gui_operator.Graphics;
import items.ItemManager;
import items.Items;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ItemPage extends JPanel implements ActionListener {

	// saves items currently chosen.
	private int currID;
	private ItemManager ItemList;

	public ItemPage() {

		// Item grid
		JPanel itemList = new JPanel(new GridLayout(2, 8));
		for (Items i : ItemList.getItemManager()) {
			String picname = "";
			picname = picname + i.getPicName();
			JLabel piclabel = new JLabel(new ImageIcon("D:/Entertainment/ToS/"
					+ picname));
			itemList.add(piclabel);
			itemList.add(piclabel, ItemList.getItem(i));
			piclabel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("Save")) {
					}
				}
			});
		}

		// packing
		setBorder(BorderFactory.createTitledBorder("Items"));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(itemList);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
