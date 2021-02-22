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

import com.qa.main.controller.ItemController;
import com.qa.main.dto.ItemDto;

import com.qa.main.persistence.domain.Item;

import com.qa.main.service.ItemService;

@SpringBootTest
@ActiveProfiles("dev")
public class ItemsControllerTest {
	
	@Autowired
	private ItemController controller;
	
	@MockBean
	private ItemService service;
	
	@Autowired
	private ModelMapper mapper;
	
	private ItemDto mapToDTO(Item item) {
		return this.mapper.map(item, ItemDto.class);
	}
	
	private final Item TEST_Item_1 = new Item(1L, "Apples","Buy");
	private final Item TEST_Item_2 = new Item(2L, "Peaches","Buy");
	private final Item TEST_Item_3 = new Item(3L,"Oranges","Buy");
	private final List<Item> ListItem = List.of(TEST_Item_1,TEST_Item_2,TEST_Item_3);
	
	private final List<Item> LISTOFITEMS = List.of(TEST_Item_1, TEST_Item_2, TEST_Item_3);
	
	@Test
	void createTest() throws Exception {
		when(this.service.create(TEST_Item_1)).thenReturn(this.mapToDTO(TEST_Item_1));
		assertThat(new ResponseEntity<ItemDto>(this.mapToDTO(TEST_Item_1), HttpStatus.CREATED))
				.isEqualTo(this.controller.create(TEST_Item_1));
		verify(this.service, Mockito.times(1)).create(TEST_Item_1);
	}
	
	@Test
	void readTest() throws Exception{
		List<ItemDto> listDto = ListItem.stream().map(this::mapToDTO).collect(Collectors.toList());
		when(this.service.readAll()).thenReturn(listDto);
		assertThat(this.controller.readAll()).isEqualTo(new ResponseEntity<>(listDto, HttpStatus.OK));
		verify(this.service, atLeastOnce()).readAll();
	}
	
	@Test
	void readByIdTest() throws Exception {
		final Long id = 2L;
		when(this.service.readById(id)).thenReturn(this.mapToDTO(TEST_Item_2));
		assertThat(new ResponseEntity<ItemDto>(this.mapToDTO(TEST_Item_2), HttpStatus.OK))
				.isEqualTo(this.controller.readOne(id));
		verify(this.service, atLeastOnce()).readById(id);
	}
	
	@Test
	void UpdateTest() throws Exception {
		final Long id = 1L;
		final ItemDto listDto = null;
		when(this.service.update(listDto, id)).thenReturn(this.mapToDTO(TEST_Item_1));
		assertThat(new ResponseEntity<ItemDto>(this.mapToDTO(TEST_Item_1), HttpStatus.ACCEPTED))
				.isEqualTo(this.controller.update(id, listDto));
		verify(this.service, atLeastOnce()).update(listDto, id);

	}
	
	@Test
	void deleteTest() throws Exception {
		when(this.service.delete(TEST_Item_2.getId())).thenReturn(false);
		assertThat(this.controller.delete(TEST_Item_2.getId()))
				.isEqualTo(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
		verify(this.service, atLeastOnce()).delete(TEST_Item_2.getId());
	}
	
	


}


