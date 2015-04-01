package items;

public class Items {
	private String name;
	private String picName;
	private int iD;
	private String description;
	
	//Constructor
	public Items(String name, String picName, int iD, 
			String description) {
		super();
		this.name = name;
		this.picName = picName;
		this.iD = iD;
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + iD;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((picName == null) ? 0 : picName.hashCode());
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
		Items other = (Items) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (iD != other.iD)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (picName == null) {
			if (other.picName != null)
				return false;
		} else if (!picName.equals(other.picName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Itemname=" + name + '\n' + "picName=" + picName + '\n' + "iD=" + iD
				+ '\n' + "description=" + description
				;
	}
	
	//getters and setters of attributes
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
