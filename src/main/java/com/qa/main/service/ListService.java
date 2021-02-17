package com.qa.main.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.main.dto.ListDto;
import com.qa.main.persistence.domain.ListName;
import com.qa.main.persistence.repo.ListRepo;
import com.qa.main.utils.SpringBeanUtil;

@Service
public class ListService {
	
	private ListRepo repo;
	
	private ModelMapper mapper;
	
	private ListDto mapToDTO(ListName list) {
		return this.mapper.map(list, ListDto.class);
	}

	@Autowired
	public ListService(ListRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	//Create
	public ListDto create(ListName list){
		return this.mapToDTO(this.repo.save(list));
	}
	
	//Read all
	public List<ListDto> readAll(){
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	
	//Read by id
	public ListDto readById(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow(null));
	}
	
	//Update 
	
	public ListDto update(ListDto listDto, Long id) {
		ListName toUpdate = this.repo.findById(id).orElseThrow();
		
		toUpdate.setName(listDto.getName());
		SpringBeanUtil.mergNotNull(listDto, toUpdate);
		return this.mapToDTO(this.repo.save(toUpdate));
	}
	
	//Delete
	public boolean delete(Long id) {
			this.repo.deleteById(id);
			return !this.repo.existsById(id);
	}
	
	
	

}
