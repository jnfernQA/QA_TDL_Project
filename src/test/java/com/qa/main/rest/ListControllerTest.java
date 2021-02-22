package com.qa.main.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.qa.main.controller.ListController;
import com.qa.main.dto.ListDto;
import com.qa.main.persistence.domain.ListName;
import com.qa.main.service.ListService;

@SpringBootTest
@ActiveProfiles("dev")
public class ListControllerTest {
	
	@Autowired
	private ListController controller;
	
	@MockBean
	private ListService service;
	
	@Autowired
	private ModelMapper mapper;
	
	private ListDto mapToDTO(ListName list) {
		return this.mapper.map(list, ListDto.class);
	}
	
	private final ListName TEST_List_1 = new ListName(1L, "Shopping");
	private final ListName TEST_List_2 = new ListName(2L, "Tasks");
	private final ListName TEST_List_3 = new ListName(3L,"Chores");
	private final List<ListName> ListList = List.of(TEST_List_1,TEST_List_2,TEST_List_3);
	
	private final List<ListName> LISTOFLISTS = List.of(TEST_List_1, TEST_List_2, TEST_List_3);
	
	@Test
	void createTest() throws Exception {
		when(this.service.create(TEST_List_1)).thenReturn(this.mapToDTO(TEST_List_1));
		assertThat(new ResponseEntity<ListDto>(this.mapToDTO(TEST_List_1), HttpStatus.CREATED))
				.isEqualTo(this.controller.create(TEST_List_1));
		verify(this.service, Mockito.times(1)).create(TEST_List_1);
	}
	
	@Test
	void readTest() throws Exception{
		List<ListDto> listDto = ListList.stream().map(this::mapToDTO).collect(Collectors.toList());
		when(this.service.readAll()).thenReturn(listDto);
		assertThat(this.controller.readAll()).isEqualTo(new ResponseEntity<>(listDto, HttpStatus.OK));
		verify(this.service, atLeastOnce()).readAll();	
	}
	
	@Test
	void readByIdTest() throws Exception {
		final Long id = 2L;
		when(this.service.readById(id)).thenReturn(this.mapToDTO(TEST_List_2));
		assertThat(new ResponseEntity<ListDto>(this.mapToDTO(TEST_List_2), HttpStatus.OK))
				.isEqualTo(this.controller.readOne(id));
		verify(this.service, atLeastOnce()).readById(id);
	}
	
	@Test
	void UpdateTest() throws Exception {
		final Long id = 1L;
		final ListDto listDto = null;
		when(this.service.update(listDto, id)).thenReturn(this.mapToDTO(TEST_List_1));
		assertThat(new ResponseEntity<ListDto>(this.mapToDTO(TEST_List_1), HttpStatus.ACCEPTED))
				.isEqualTo(this.controller.update(id, listDto));
		verify(this.service, atLeastOnce()).update(listDto, id);

	}
	
	@Test
	void deleteTest() throws Exception {
		when(this.service.delete(TEST_List_2.getId())).thenReturn(false);
		assertThat(this.controller.delete(TEST_List_2.getId()))
				.isEqualTo(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
		verify(this.service, atLeastOnce()).delete(TEST_List_2.getId());
	}
	
	


}
