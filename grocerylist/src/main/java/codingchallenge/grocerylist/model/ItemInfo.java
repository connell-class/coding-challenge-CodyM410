package codingchallenge.grocerylist.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

enum GroceryType {
	FOOD, ELECTRONICS, CLOTHING, COSMETICS, TOYS, HEALTHCARE
}

@Entity
@Table(name="item_info")
public class ItemInfo {
	@Column
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private GroceryType type;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="item_list")
	@JsonIgnore
	private ItemList groceryList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GroceryType getType() {
		return type;
	}

	public void setType(GroceryType type) {
		this.type = type;
	}

	public ItemList getGroceryList() {
		return groceryList;
	}

	public void setGroceryList(ItemList groceryList) {
		this.groceryList = groceryList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groceryList == null) ? 0 : groceryList.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ItemInfo other = (ItemInfo) obj;
		if (groceryList == null) {
			if (other.groceryList != null)
				return false;
		} else if (!groceryList.equals(other.groceryList))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroceryItem [id=" + id + ", name=" + name + ", type=" + type + ", groceryList=" + groceryList + "]";
	}
}
