package map;

public class Map {
	private String name;
	private int [][] mapping;
	private int width;
	private int height;
	
	//constructor
	public Map(String name, int width, int height) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
		this.mapping = new int [height][width];
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				this.mapping[i][j] = 0;
	}
	
	//constructor with width and height be 20
	public Map(String name) {
		super();
		this.name = name;
		this.width = 20;
		this.height = 20;
		this.mapping = new int [this.height][this.width];
		for (int i = 0; i < this.height; i++){
			for (int j = 0; j < this.width; j++){
				this.mapping[i][j] = 0;
			}
		}
	}
	
	// set the mapping in provided coordinate to the item ID
	public void setMapItem(int ID, int x, int y){
		mapping[x][y] = ID;
	}
	
	// get the item id by giving the xy-coordinate
	public int getMapItem(int x, int y){
		if (x < 0 || x > width || y < 0 || y > height)
			return -1;
		return mapping[x][y];
	}
	
	@Override
	public String toString() {
		return "Map " + name + " mapping: " + "\n" + mapToString(mapping)
				+ "\n" + ", width=" + width + ", height=" + height;
	}

	//helper of toString()
	public String mapToString(int[][] mapping) {
		String map = "";
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				map = map + getMapItem(i, j) + " ";
			map = map + "\n";
		return map;
	}
	
	//getters and setters
	public int[][] getMapping() {
		return mapping;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
