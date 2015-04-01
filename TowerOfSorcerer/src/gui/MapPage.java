package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import map.Map;
import map.MapManager;

public class MapPage extends JPanel implements ActionListener {

	private JButton addButton = new JButton("New Map");
	private JButton delButton = new JButton("Delete Map");
	private MapManager MapList = new MapManager();
	private JComboBox<String> mapSelection = new JComboBox<String>();

	public MapPage() {
		// initialization
		MapList.addMap("1 floor", -1, -1);

		// north: map level, delete, add new map
		JPanel MapPanel = new JPanel();
		for (Map m : MapList.getMapManager())
			mapSelection.addItem(m.getName());

		MapPanel.add(mapSelection);
		mapSelection.addActionListener(this);
		MapPanel.add(addButton);
		addButton.addActionListener(this);
		MapPanel.add(delButton);
		delButton.addActionListener(this);

		// center: map grid
		Map currmap = MapList
				.searchMap((String) mapSelection.getSelectedItem());
		JPanel mapDetail = new JPanel(new GridLayout(currmap.getWidth(),
				currmap.getHeight()));
		//TODO: handle the graphic input problem
		for (int i = 0; i < currmap.getHeight(); i++) {
			for (int j = 0; j < currmap.getWidth(); j++) {
				String picname = currmap.getMapItem(i, j) + ".png";
				JLabel mapPiece = new JLabel(new ImageIcon(
						"D:/Entertainment/ToS/" + picname));
				mapDetail.add(mapPiece, j + i * currmap.getWidth());
			}
		}
		
		// packing
		setBorder(BorderFactory.createTitledBorder("Maps"));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(MapPanel);
		add(mapDetail);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent But) {
		if (But.getSource() == addButton) { // adding new map

		} else if (But.getSource() == delButton) { // delete current map
			if (mapSelection.getItemCount() == 1) {
				JOptionPane.showMessageDialog(this,
						"You can't have a tower with no map!", "Map Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				String curr = (String) mapSelection.getSelectedItem();
				MapList.deleteMap(curr);
			}
		} else if (But.getSource() == mapSelection) {

		}
	}

}
