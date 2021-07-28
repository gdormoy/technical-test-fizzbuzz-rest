package com.technical.test.application;

import com.technical.test.controller.FizzBuzzController;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class ApplicationTests {
	protected FizzBuzzController controller = new FizzBuzzController();

	@Test
	public void testfizzBuzzOrNumberAssertFizz(){
		assertEquals("fizz", controller.fizzBuzzOrNumber(18, 3, 5, "fizz", "buzz"));
	}

	@Test
	public void testfizzBuzzOrNumberAssertBuzz(){
		assertEquals("buzz", controller.fizzBuzzOrNumber(20, 3, 5, "fizz", "buzz"));
	}

	@Test
	public void testfizzBuzzOrNumberAssertFizzBuzz(){
		assertEquals("fizzbuzz", controller.fizzBuzzOrNumber(15, 3, 5, "fizz", "buzz"));
	}

	@Test
	public void testIsMultipleAssertTrue(){
		assertTrue(controller.isMultiple(18, 3));
	}

	@Test
	public void testIsMultipleAssertFalse(){
		assertFalse(controller.isMultiple(18, 5));
	}

}
