package com.qa.main.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.main.dto.ListDto;
import com.qa.main.persistence.domain.ListName;
import com.qa.main.persistence.repo.ListRepo;

@SpringBootTest
@ActiveProfiles("dev")
public class ListServiceTest {
	
	private final ListName TEST_List_1 = new ListName("Shopping");
	private final ListName TEST_List_2 = new ListName("Tasks");
	
	private final ListName TEST_List_ID = new ListName(null,"Shopping");
	private final ListName TEST_List_S = new ListName(1L, TEST_List_ID.getName());
	private final List<ListName> listName = List.of(TEST_List_1, TEST_List_2);
	
	@Autowired
	ListService service;

	@MockBean
	ListRepo repo;

	@Autowired
	private ModelMapper mapper;

	private ListDto mapToDTO(ListName list) {
		return this.mapper.map(list, ListDto.class);
	}
	
	@Test
	void createTest() throws Exception {
		final ListName TEST_List_ID1 = new ListName(null, "Shopping");
		final ListName TEST_List_S1 = new ListName(1L, "Shopping");
		when(this.repo.save(TEST_List_ID1)).thenReturn(TEST_List_S1);
		assertThat(this.service.create(TEST_List_ID1)).isEqualTo(this.mapToDTO(TEST_List_S1));
		verify(this.repo, atLeastOnce()).save(TEST_List_ID1);
	}

	@Test
	void readAllTest() throws Exception {
		List<ListDto> listDto = listName.stream().map(this::mapToDTO).collect(Collectors.toList());
		when(this.repo.findAll()).thenReturn(listName);
		assertThat(this.service.readAll()).isEqualTo(listDto);
		verify(this.repo, atLeastOnce()).findAll();
	}

	@Test
	void readByIdTest() throws Exception {
		final Long id = 2L;
		ListName TEST_List_ID2 = new ListName(id, "Shopping");
		when(this.repo.findById(id)).thenReturn(Optional.of(TEST_List_ID2));
		assertThat(this.service.readById(id)).isEqualTo(this.mapToDTO(TEST_List_ID2));
		verify(this.repo, atLeastOnce()).findById(id);

	}

	@Test
	void updateTest() throws Exception {
		final Long id = 1L;
		when(this.repo.findById(id)).thenReturn(Optional.of(TEST_List_1));
		when(this.repo.save(TEST_List_S)).thenReturn(TEST_List_S);
		assertThat(this.service.update(this.mapToDTO(TEST_List_S), id)).isEqualTo(this.mapToDTO(TEST_List_1));
		verify(this.repo, atLeastOnce()).findById(id);
		verify(this.repo, atLeastOnce()).save(TEST_List_S);

	}

	@Test
	void deleteTest() throws Exception {
		final Long id = 2L;
		when(this.repo.existsById(id)).thenReturn(false);
		assertThat(this.service.delete(id)).isEqualTo(true);
		verify(this.repo, atLeastOnce()).existsById(id);

	}

}


