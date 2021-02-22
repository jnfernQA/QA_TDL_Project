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
import com.qa.main.dto.ItemDto;
import com.qa.main.persistence.domain.Item;
import com.qa.main.persistence.domain.ListName;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@Sql(scripts = { "classpath:List-schema.sql",
				"classpath:List-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class ItemsControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper jsonifier;

	@Autowired
	private ModelMapper mapper;

	private ItemDto mapToDTO(Item item) {
		return this.mapper.map(item, ItemDto.class);
	}
	
	private final ListName TEST_List_1 = new ListName(1L, "Shopping");
	private final ListName TEST_List_2 = new ListName(2L, "Tasks");
	private final ListName TEST_List_3 = new ListName(3L,"Chores");
	private final Item Test_Item_1 = new Item(1L, "Buy", "Apples");
	private final Item Test_Item_2 = new Item(2L, "Buy", "Peaches");
	private final Item Test_Item_3 = new Item(3L, "Buy", "CheeseCake");
	
	private final List<ListName> LISTOFLISTS = List.of(TEST_List_1, TEST_List_2, TEST_List_3);
	private final List<Item> listItems = List.of(Test_Item_1, Test_Item_2, Test_Item_3);
	private final String URI = "/item";
	
	@Test
	void testCreate() throws Exception {
		ItemDto Test_Item = mapToDTO(new Item("Potatoes","To EAT"));
		ItemDto Test_Item_S = mapToDTO(new Item("Potatoes","To EAT"));
		String testItemToJSON = this.jsonifier.writeValueAsString(Test_Item);
		Test_Item_S.setId(4L);
		String testItemSavedToJSON = this.jsonifier.writeValueAsString(Test_Item_S);
		RequestBuilder rB = post(URI + "/create").contentType(MediaType.APPLICATION_JSON).content(testItemToJSON);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testItemSavedToJSON);
		this.mvc.perform(rB).andExpect(checkStatus).andExpect(checkBody);

	}
	
	@Test
	void testReadLatest() throws Exception {
		

		RequestBuilder rB = get(URI + "/read/" + Test_Item_1.getId()).accept(MediaType.APPLICATION_JSON);
		ResultMatcher checkStatus = status().isOk();
		this.mvc.perform(rB).andExpect(checkStatus)
				.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(Test_Item_1))));

	}
	
	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete(URI + "/delete/" + Test_Item_1.getId())).andExpect(status().isNoContent());
	}

}
