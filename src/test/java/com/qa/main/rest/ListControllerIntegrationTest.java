package com.qa.main.rest;


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
	
	private final List<ListName> LISTOFLISTS = List.of(TEST_List_1, TEST_List_2, TEST_List_3);
	
	private final String URL = "/list";
	
//	@Test
//	void createTest() throws Exception {
//		ListDto testDto = mapToDTO(new ListName("Shopping"));
//		String testDTOAsJSON = this.jsonifier.writeValueAsString(testDto);
//
//		RequestBuilder request = post(URL + "/create").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);
//
//		ResultMatcher checkStatus = status().isCreated();
//
//		ListDto testSavedDto = mapToDTO(new ListName("Shopping"));
//
//		testSavedDto.setId(4L);
//		String TestSavedDtoAsJson = this.jsonifier.writeValueAsString(testSavedDto);
//
//		ResultMatcher checkBody = content().json(TestSavedDtoAsJson);
//
//		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
//
//	}

}
