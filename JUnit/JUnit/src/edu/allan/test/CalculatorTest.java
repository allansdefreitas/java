package edu.allan.test;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.allan.model.Calculator;

class CalculatorTest {

	@Test
	void SumTest() {
		int sum = Calculator.sum(1, 1);
		Assertions.assertEquals(2, sum);
	}
	
	@Test
	void givenEvenNumber_whenCheckingIsNumberEven_thenTrue() {
	    boolean result = Calculator.isEven(8);

	    Assertions.assertTrue(result);
	}

	@Test
	void givenOddNumber_whenCheckingIsNumberEven_thenFalse() {
	    boolean result = Calculator.isEven(3);

	    Assertions.assertFalse(result);
	}
	
	
	@Test
	void givenLowerThanTenNumber_whenCheckingIsNumberEven_thenResultUnderTenMillis() {
	    Assertions.assertTimeout(Duration.ofMillis(10), () -> Calculator.isEven(3));
	}
		
	@Test
	void givenNull_whenCheckingIsNumberEven_thenNullPointerException() {
	    Assertions.assertThrows(NullPointerException.class, () -> Calculator.isEven(null));
	}
	
	@Test
	void timeoutNotExceeded() {
		// The following assertion succeeds.
		Assertions.assertTimeout(Duration.ofMinutes(2), () -> {
			// Perform task that takes less than 2 minutes.
		});
	}

}
