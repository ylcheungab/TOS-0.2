package map;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MapManager {
	private ArrayList<Map> mapManager;
	
	//Remove the map from the maplist in 2 ways: name or the map
	public void deleteMap(String mapName){
		try{
			mapManager.remove(searchMap(mapName));
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "Error occurs.",
					"Warning!", JOptionPane.ERROR_MESSAGE);
		}		
	}
	public void deleteMap(Map map){
		mapManager.remove(map);
	}
	
	//adding a new map into the maplist
	public void addMap(String name, int width, int height){
		if (width != -1 && height != -1)
			mapManager.add(new Map(name, width, height));
		else
			mapManager.add(new Map(name));
	}
	
	//get map with the map name
	public Map searchMap(String mapName){
		for (Map m : mapManager)
			if (mapName.equals(m.getName()))
				return m;
		return null;
	}
	
	//list all of the IDs stored in the map
	public void listMap(){
		for (Map i : mapManager)
			System.out.println(i);
	}
	
	public ArrayList<Map> getMapManager() {
		return mapManager;
	}
	
	public void setMapManager(ArrayList<Map> mapManager) {
		this.mapManager = mapManager;
	}
	
	public MapManager(ArrayList<Map> mapManager) {
		super();
		this.mapManager = mapManager;
	}
	
	public MapManager() {
		super();
		this.mapManager = new ArrayList<Map>();
	}
}
