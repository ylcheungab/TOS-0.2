package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ContentPage extends JFrame implements ActionListener{
	
	private JMenu Content = new JMenu("Content");
	private MapPage Map = new MapPage();
	private ItemPage Item = new ItemPage();
	private DescPage Description = new DescPage();
	
	public ContentPage (){
		setTitle("Tower of Sorcerer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent But) {
				int n = JOptionPane.showConfirmDialog(null, "Exit without saving?",
						"Comfirm", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION)
					dispose();
			}
		});
		
		//menu bar
		setJMenuBar(createMenuBar());
		
		//panel
		JPanel ItemDesc = new JPanel();
		ItemDesc.setLayout(new BoxLayout(ItemDesc, BoxLayout.Y_AXIS));
		ItemDesc.add(Item);
		ItemDesc.add(Description);
		
		//packing
		setEnabled(true);
		getContentPane().add(BorderLayout.CENTER, Map);
		getContentPane().add(BorderLayout.EAST, ItemDesc);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	JMenuBar createMenuBar() {
		//menus in menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.getAccessibleContext().setAccessibleName("Operator operations");

		//file menu
		JMenu FileMenu = (JMenu) menuBar.add(new JMenu("File"));
		FileMenu.setMnemonic('F');
		FileMenu.getAccessibleContext().setAccessibleDescription(
				"File Management");
		
		JMenuItem mi;	// the elements in file menu
		
		// item menu item button
		mi = (JMenuItem) FileMenu.add(new JMenuItem("New Item"));
		mi.setMnemonic('I');
		mi.getAccessibleContext().setAccessibleDescription("Item addition");
		//TODO build this!
//		mi.addActionListener(new NewItemPage());	
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
