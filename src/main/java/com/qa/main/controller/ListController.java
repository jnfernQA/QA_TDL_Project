package com.qa.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.dto.ListDto;
import com.qa.main.persistence.domain.ListName;
import com.qa.main.service.ListService;

@RestController
@CrossOrigin
@RequestMapping("/list")
public class ListController {
	
	private ListService service;

	@Autowired
	public ListController(ListService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<ListDto> create(@RequestBody ListName list){
		ListDto created = this.service.create(list);
		return new ResponseEntity<>(created,HttpStatus.CREATED);
	}
	
	@GetMapping("/read")
	public ResponseEntity<List<ListDto>> readAll(){
		return ResponseEntity.ok(this.service.readAll());
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<ListDto> readOne(@PathVariable Long id){
		return ResponseEntity.ok(this.service.readById(id));
	}
	
	//Update
	@PutMapping("/create/{id}")
	public ResponseEntity<ListDto> update(@PathVariable Long id, @RequestBody ListDto listDto){
		return new ResponseEntity<>(this.service.update(listDto,  id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ListDto> delete(@PathVariable Long id) {
	    return this.service.delete(id)? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
	    		: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
