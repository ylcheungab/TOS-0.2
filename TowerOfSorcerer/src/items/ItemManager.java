package items;

import java.awt.Image;
import java.util.ArrayList;

public class ItemManager {
	private ArrayList<Items> ItemManager;

	public int count(){
		return ItemManager.size();
	}
	
	public ArrayList<Items> getItemManager() {
		return ItemManager;
	}

	public void setItemManager(ArrayList<Items> itemManager) {
		ItemManager = itemManager;
	}

	//list out all items in system output
	public void listItem(){
		for (Items i : ItemManager)
			System.out.println(i);
	}
	
	//Remove the item from the itemlist in 2 ways: ID or the item
	public void deleteItem(Items item){
		ItemManager.remove(item);
	}
	public void deleteItem(int ID){
		ItemManager.remove(searchItems(ID));
	}
	
	//Add new items into the list by constructing new item
	public void addItem(String name, Image pic,  String description){
		ItemManager.add(new Items(name, pic, description));
	}
	
	//searching item using the item list place
	public Items searchItems(int il){
		return ItemManager.get(il);
	}
	//searching item using the item
	public int searchItems(Items item){
		for (int i = 0; i < ItemManager.size(); i++)
			if (item.equals(ItemManager.get(i)))
				return i;
		return -1;
	}
	
	//list out all item ID
	@Override
	public String toString() {
		String s = "";
		for (Items i :ItemManager)
			s = i.toString() + '\n';
		return "ItemManager" + '\n' + s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ItemManager == null) ? 0 : ItemManager.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemManager other = (ItemManager) obj;
		if (ItemManager == null) {
			if (other.ItemManager != null)
				return false;
		} else if (!ItemManager.equals(other.ItemManager))
			return false;
		return true;
	}
	
	public ItemManager(ArrayList<Items> itemGroup) {
		super();
		this.ItemManager = itemGroup;
	}

	public ItemManager() {
		super();
		this.ItemManager = new ArrayList<Items>();
	}
}
