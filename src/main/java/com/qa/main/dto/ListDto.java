package com.qa.main.dto;

import java.util.ArrayList;
import java.util.List;

public class ListDto {
	
	private Long id;
	private String name;
	private List<ItemDto> item = new ArrayList<>();	
	
	//Default Constructor
	public ListDto() {
		super();
	}
	
	public ListDto(Long id, String name, List<ItemDto> item) {
		super();
		this.id = id;
		this.name = name;
		this.item = item;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<ItemDto> getItem() {
		return item;
	}

	public void setItem(List<ItemDto> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ListDto [id=" + id + ", name=" + name + ", item=" + item + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ListDto other = (ListDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	
	

}
