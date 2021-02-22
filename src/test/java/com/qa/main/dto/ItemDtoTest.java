package com.qa.main.dto;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemDtoTest {
	
	private ItemDto ItemTestdto;

	@BeforeEach
	public void beforeTest() {
		ItemTestdto = new ItemDto();

	}

	@Test
	public void hashCodeTest() {
		ItemTestdto.hashCode();
	}

	@Test
	public void toStringTest() {
		ItemTestdto.toString();

	}

	@Test
	public void constructorTest() {
		ItemTestdto = new ItemDto();
		assertTrue(ItemTestdto instanceof ItemDto);
		assertNotNull(ItemTestdto);

	}


}
