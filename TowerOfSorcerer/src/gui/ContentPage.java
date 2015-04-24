package gui;

import items.ItemManager;
import items.Items;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import map.Map;
import map.MapManager;

public class ContentPage extends JFrame implements ActionListener {

	private Items currItem = null;
	private Map currMap = null;

	// menu bar
	private JMenu Content = new JMenu("Content");

	// map
	private JButton addMapButton = new JButton("New Map");
	private JButton delMapButton = new JButton("Delete Map");
	private MapManager MapList = new MapManager();
	private JComboBox<String> mapSelection = new JComboBox<String>();
	private JTable MapListTable;

	// item list
	private ItemManager ItemList;
	private JTable ItemListTable;

	// description
	JPanel contentDescP = new DescPage(currItem);
	private JButton editItemButton = new JButton("Edit");
	private JButton delItemButton = new JButton("Delete");

	public ContentPage() {
		setTitle("Tower of Sorcerer");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent But) {
				int n = JOptionPane.showConfirmDialog(null,
						"Exit without saving?", "Comfirm",
						JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION)
					dispose();
			}
		});

		// menu bar
		setJMenuBar(createMenuBar());

		// left panel: map panel
		JPanel leftP = new JPanel();

		for (Map m : MapList.getMapManager())
			mapSelection.addItem(m.getName());
		leftP.add(mapSelection);
		mapSelection.addActionListener(this);
		leftP.add(addMapButton);
		addMapButton.addActionListener(this);
		leftP.add(delMapButton);
		delMapButton.addActionListener(this);

		// mapping (changable)
		MapListTable = new JTable(new mapTableModel());
		MapListTable.setAutoResizeMode(MapListTable.AUTO_RESIZE_ALL_COLUMNS);
		MapListTable.setRowHeight(32);
		JTableHeader h = MapListTable.getTableHeader();
		h.setResizingAllowed(false);
		h.setReorderingAllowed(false);

		MapListTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setMapItem(e);
			}

			public void mouseReleased(MouseEvent e) {
			}
		});

		// right panel : item + description panel
		JPanel rightP = new JPanel();
		rightP.setLayout(new BorderLayout());
		rightP.setPreferredSize(new Dimension(250, 430));

		// item panel
		// border
		JPanel itemP = new JPanel();
		TitledBorder b = BorderFactory.createTitledBorder("Items");
		b.setTitleColor(new Color(51, 204, 51));
		Font f = new Font("Helvetica", Font.BOLD + Font.ITALIC, 11);
		b.setTitleFont(f);
		itemP.setBorder(b);

		// item list (changable)
		ItemListTable = new JTable(new itemTableModel());
		ItemListTable.setAutoResizeMode(ItemListTable.AUTO_RESIZE_ALL_COLUMNS);
		ItemListTable.setRowHeight(32);
		JTableHeader h2 = ItemListTable.getTableHeader();
		h2.setResizingAllowed(false);
		h2.setReorderingAllowed(false);

		// add listener on table
		ItemListTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				getSelectionItem(e);
			}

			public void mouseReleased(MouseEvent e) {
			}
		});

		// warp up the item panel
		JScrollPane scrollpane = new JScrollPane(ItemListTable);
		scrollpane.setBorder(new BevelBorder(BevelBorder.LOWERED));
		scrollpane.setPreferredSize(new Dimension(250, 90));
		itemP.add(scrollpane, BorderLayout.CENTER);

		// content description panel (changable)
		contentDescP = new DescPage(currItem);
		contentDescP.setPreferredSize(new Dimension(250, 300));

		// button panel in description panel
		delItemButton.addActionListener(this);
		editItemButton.addActionListener(this);
		JPanel buttP = new JPanel();
		buttP.setLayout(new BoxLayout(buttP, BoxLayout.X_AXIS));
		buttP.add(editItemButton);
		buttP.add(delItemButton);

		// warp up description panel
		JPanel descP = new JPanel();
		TitledBorder b1 = BorderFactory.createTitledBorder("Descriptions");
		b1.setTitleColor(new Color(102, 0, 51));
		Font f1 = new Font("Helvetica", Font.BOLD + Font.ITALIC, 11);
		b1.setTitleFont(f1);
		descP.setBorder(b1);
		descP.setLayout(new BorderLayout());
		descP.add(contentDescP, BorderLayout.CENTER);
		descP.add(buttP, BorderLayout.SOUTH);

		// warp up right panel
		rightP.add(itemP, BorderLayout.NORTH);
		rightP.add(descP, BorderLayout.CENTER);

		// packing
		setEnabled(true);
		setLayout(new BorderLayout());
		getContentPane().add(BorderLayout.WEST, leftP);
		getContentPane().add(BorderLayout.CENTER, rightP);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	JMenuBar createMenuBar() {
		// menus in menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.getAccessibleContext().setAccessibleName("Operator operations");

		// file menu
		JMenu FileMenu = (JMenu) menuBar.add(new JMenu("File"));
		FileMenu.setMnemonic('F');
		FileMenu.getAccessibleContext().setAccessibleDescription(
				"File Management");

		JMenuItem mi; // the elements in file menu

		// item menu item button
		mi = (JMenuItem) FileMenu.add(new JMenuItem("New Item"));
		mi.setMnemonic('I');
		mi.getAccessibleContext().setAccessibleDescription("Item addition");
		// TODO build this!
		// mi.addActionListener(new NewItemPage());

		mi = (JMenuItem) FileMenu.add(new JMenuItem("Map"));
		mi.setMnemonic('M');

		mi = (JMenuItem) FileMenu.add(new JMenuItem("Options"));

		mi = (JMenuItem) FileMenu.add(new JMenuItem("Save"));

		menuBar.add(Content);
		Content.setEnabled(false);
		Content.setMnemonic('p');
		Content.getAccessibleContext().setAccessibleDescription(
				"Appointment Management");
		mi = new JMenuItem("Manual Scheduling");
		Content.add(mi);

		return menuBar;

	}

	class mapTableModel extends AbstractTableModel {

		public int getColumnCount() {
			return currMap.getWidth();
		}

		public int getRowCount() {
			return currMap.getHeight();
		}

		public Object getValueAt(int row, int col) {
			return ItemList.searchItems(currMap.getMapItem(row, col)).getPic();
		}

		public Class getColumnClass(int col) {
			return Image.class;
		}

		public boolean isCellEditable(int row, int col) {
			return false;
		}

	}

	class itemTableModel extends AbstractTableModel {

		private static final long serialVersionUID = 1L;

		public int getColumnCount() {
			return 8;
		}

		public int getRowCount() {
			if (4 > ItemList.count() / 8 + 1)
				return 4;
			else
				return ItemList.count() / 8 + 1;
		}

		public Object getValueAt(int row, int col) {
			return ItemList.searchItems(row * 8 + col).getPic();
		}

		public Class getColumnClass(int col) {
			return Image.class;
		}

		public boolean isCellEditable(int row, int col) {
			return false;
		}
	}

	private void getSelectionItem(MouseEvent e) {
		Items temp = ItemList.searchItems(ItemListTable.getSelectedRow()
				* ItemListTable.getRowCount()
				+ ItemListTable.getSelectedColumn());
		if (!currItem.equals(temp))
			currItem = temp;
		else
			currItem = null;
		contentDescP = new DescPage(currItem);
	}

	private void setMapItem(MouseEvent e) {
		if (currItem != null) {
			int itemID = ItemList.searchItems(currItem);
			int x = MapListTable.getSelectedColumn();
			int y = MapListTable.getSelectedRow();
			currMap.setMapItem(itemID, x, y);
		}else{
			JOptionPane.showMessageDialog(null, "No item selected.",
					"Error!", JOptionPane.ERROR_MESSAGE);
		}
	}

	// actions for buttons and combo box
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addMapButton) { // adding new map

		} else if (e.getSource() == delMapButton) { // delete current map
			if (mapSelection.getItemCount() == 1) {
				
			} else {
				String curr = (String) mapSelection.getSelectedItem();
				MapList.deleteMap(curr);
			}
		} else if (e.getSource() == mapSelection) {

		} else if (e.getSource() == editItemButton) {
			
		} else if (e.getSource() == delItemButton) {
			
		}

	}

}
