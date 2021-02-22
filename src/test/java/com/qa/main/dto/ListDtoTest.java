package com.qa.main.dto;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListDtoTest {
	private ListDto listTestdto;

	@BeforeEach
	public void beforeTest() {
		listTestdto = new ListDto();

	}

	@Test
	public void hashCodeTest() {
		listTestdto.hashCode();
	}

	@Test
	public void toStringTest() {
		listTestdto.toString();

	}

	@Test
	public void constructorTest() {
		listTestdto = new ListDto();
		assertTrue(listTestdto instanceof ListDto);
		assertNotNull(listTestdto);

	}

}
