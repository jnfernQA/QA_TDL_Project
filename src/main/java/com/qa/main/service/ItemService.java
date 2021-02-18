package com.qa.main.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.main.dto.ItemDto;
import com.qa.main.persistence.domain.Item;
import com.qa.main.persistence.repo.ItemRepo;
import com.qa.main.utils.SpringBeanUtil;

@Service
public class ItemService {
	
	private ItemRepo repo;
	
	private ModelMapper mapper;
	
	private ItemDto mapToDTO(Item items) {
		return this.mapper.map(items, ItemDto.class);
	}
	
	@Autowired
	public ItemService(ItemRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	//create
	public ItemDto create(Item item) {
		return this.mapToDTO(this.repo.save(item));
	}
	
	//Read all
	public List<ItemDto> readAll(){
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	//Read by id
	
	public ItemDto readById(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow(null));
	}
	
	//Update
	public ItemDto update(ItemDto itemDto, Long id) {
		Item toUpdate =this.repo.findById(id).orElseThrow();
		
		toUpdate.setItem_name(itemDto.getItem_name());
		toUpdate.setItem_action(itemDto.getItem_action());
		SpringBeanUtil.mergeNotNull(itemDto,toUpdate);
		return this.mapToDTO(this.repo.save(toUpdate));
	}
	
	//Delete
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
