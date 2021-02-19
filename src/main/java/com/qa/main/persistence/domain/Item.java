package com.qa.main.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String item_name;
	
	@NotNull
	private String item_action;
	
	@ManyToOne
	private ListName listName;
	
	//Constructors
	public Item() {
		
	}

	public Item(@NotNull String item_name, @NotNull String item_action, ListName listName) {
		super();
		this.item_name = item_name;
		this.item_action = item_action;
		this.listName = listName;
	}
	
	public Item(Long id, @NotNull String item_name, @NotNull String item_action, ListName listName) {
		super();
		this.id = id;
		this.item_name = item_name;
		this.item_action = item_action;
		this.listName = listName;
	}
	
	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_action() {
		return item_action;
	}

	public void setItem_action(String item_action) {
		this.item_action = item_action;
	}
	
	public ListName getListName() {
		return listName;
	}

	public void setListName(ListName listName) {
		this.listName = listName;
	}
	
	
	//ToString Method
	@Override
	public String toString() {
		return "Item [id=" + id + ", item_name=" + item_name + ", item_action=" + item_action + ", listName=" + listName
				+ "]";
	}
	
	
	//HashCode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((item_action == null) ? 0 : item_action.hashCode());
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
		result = prime * result + ((listName == null) ? 0 : listName.hashCode());
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
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (item_action == null) {
			if (other.item_action != null)
				return false;
		} else if (!item_action.equals(other.item_action))
			return false;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		if (listName == null) {
			if (other.listName != null)
				return false;
		} else if (!listName.equals(other.listName))
			return false;
		return true;
	}

}
