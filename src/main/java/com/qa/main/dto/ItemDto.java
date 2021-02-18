package com.qa.main.dto;

public class ItemDto {
	
	private Long id;
	private String item_name;
	private String item_action;
	
	//Default Constructor
	public ItemDto() {
		super();
	}

	public ItemDto(Long id, String item_name, String item_action) {
		super();
		this.id = id;
		this.item_name = item_name;
		this.item_action = item_action;
	}

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

	@Override
	public String toString() {
		return "ItemDto [id=" + id + ", item_name=" + item_name + ", item_action=" + item_action + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((item_action == null) ? 0 : item_action.hashCode());
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
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
		ItemDto other = (ItemDto) obj;
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
		return true;
	}
	
	

}
