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

import com.qa.main.dto.ItemDto;
import com.qa.main.persistence.domain.Item;
import com.qa.main.persistence.repo.ItemRepo;

@SpringBootTest
@ActiveProfiles("dev")
public class ItemServiceTests {
	
	private final Item Test_Item_1 = new Item("Apples", "Buy");
	private final Item Test_Item_2 = new Item("Peaches", "Buy");
	private final Item Test_Item_N = new Item(null, "Apples", "Buy");
	private final Item Test_Item_U = new Item(1L, Test_Item_N.getItem_name(), Test_Item_N.getItem_action());
	private final List<Item> listItem = List.of(Test_Item_1, Test_Item_1);
	
	@Autowired
	ItemService service;

	@MockBean
	ItemRepo repo;

	@Autowired
	private ModelMapper mapper;

	private ItemDto mapToDTO(Item item) {
		return this.mapper.map(item, ItemDto.class);
	}
	
	@Test
	void testCreate() throws Exception {
		final Item Test_Item_1N = new Item(null, "Apples", "Buy");
		final Item TEST_Item_S = new Item(1L, "Apples", "Buy");
		when(this.repo.save(Test_Item_1N)).thenReturn(TEST_Item_S);
		assertThat(this.service.create(Test_Item_1N)).isEqualTo(this.mapToDTO(TEST_Item_S));
		verify(this.repo, atLeastOnce()).save(Test_Item_1N);
	}

	@Test
	void testReadAll() throws Exception {
		List<ItemDto> itemDto = listItem.stream().map(this::mapToDTO).collect(Collectors.toList());
		when(this.repo.findAll()).thenReturn(listItem);
		assertThat(this.service.readAll()).isEqualTo(itemDto);
		verify(this.repo, atLeastOnce()).findAll();
	}

	@Test
	void testReadLatest() throws Exception {
		final Long id = 2L;
		Item Test_Item_ID = new Item(id, "Peaches","Buy");
		when(this.repo.findById(id)).thenReturn(Optional.of(Test_Item_ID));
		assertThat(this.service.readById(id)).isEqualTo(this.mapToDTO(Test_Item_ID));
		verify(this.repo, atLeastOnce()).findById(id);

	}

	@Test
	void testUpdate() throws Exception {
		final Long id = 1L;
		when(this.repo.findById(id)).thenReturn(Optional.of(Test_Item_1));
		when(this.repo.save(Test_Item_U)).thenReturn(Test_Item_U);
		assertThat(this.service.update(this.mapToDTO(Test_Item_U), id)).isEqualTo(this.mapToDTO(Test_Item_U));
		verify(this.repo, atLeastOnce()).findById(id);
		verify(this.repo, atLeastOnce()).save(Test_Item_U);

	}

	@Test
	void testDelete() throws Exception {
		final Long id = 2L;
		when(this.repo.existsById(id)).thenReturn(false);
		assertThat(this.service.delete(id)).isEqualTo(true);
		verify(this.repo, atLeastOnce()).existsById(id);

	}

	
	

}
