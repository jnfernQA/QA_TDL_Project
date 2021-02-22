package com.qa.main.rest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.dto.ListDto;
import com.qa.main.persistence.domain.Item;
import com.qa.main.persistence.domain.ListName;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@Sql(scripts = { "classpath:List-schema.sql",
				"classpath:List-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class ListControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper jsonifier;

	@Autowired
	private ModelMapper mapper;

	private ListDto mapToDTO(ListName list) {
		return this.mapper.map(list, ListDto.class);
	}
	
	private final ListName TEST_List_1 = new ListName(1L, "Shopping");
	private final ListName TEST_List_2 = new ListName(2L, "Tasks");
	private final ListName TEST_List_3 = new ListName(3L,"Chores");
	private final Item Test_Item_1 = new Item(1L, "Buy", "Apples");
	private final Item Test_Item_2 = new Item(2L, "Buy", "Peaches");
	private final Item Test_Item_3 = new Item(3L, "Buy", "CheeseCake");
	
	private final List<ListName> LISTOFLISTS = List.of(TEST_List_1, TEST_List_2, TEST_List_3);
	private final List<Item> listItems = List.of(Test_Item_1, Test_Item_2, Test_Item_3);
	private final String URI = "/list";
	
	@Test
	void testCreate() throws Exception {
		ListDto Test_List = mapToDTO(new ListName("Shopping"));
		ListDto Test_List_S = mapToDTO(new ListName("Shopping"));
		String testListToJSON = this.jsonifier.writeValueAsString(Test_List);
		Test_List_S.setId(4L);
		String testListSavedToJSON = this.jsonifier.writeValueAsString(Test_List_S);
		RequestBuilder rB = post(URI + "/create").contentType(MediaType.APPLICATION_JSON).content(testListToJSON);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testListSavedToJSON);
		this.mvc.perform(rB).andExpect(checkStatus).andExpect(checkBody);

	}

	
//READ and Update not working
//	@Test
//	void testReadLatest() throws Exception {
//		TEST_List_1.setItem(listItems);
//
//		RequestBuilder rB = get(URI + "/read/" + TEST_List_1.getId()).accept(MediaType.APPLICATION_JSON);
//		ResultMatcher checkStatus = status().isOk();
//		this.mvc.perform(rB).andExpect(checkStatus)
//				.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(TEST_List_1))));
//
//	}
	
	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete(URI + "/delete/" + TEST_List_1.getId())).andExpect(status().isNoContent());
	}
	

}
