package edu.allan.test;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.allan.model.Calculator;

class TimeoutTest {

	
	@Test
	void givenLowerThanTenNumber_whenCheckingIsNumberEven_thenResultUnderTenMillis() {
	    Assertions.assertTimeout(Duration.ofMillis(4), () -> Calculator.isEven(3));
	}
	
	@Test
	void timeoutNotExceeded() {
		// The following assertion succeeds.
		Assertions.assertTimeout(Duration.ofMinutes(2), () -> {
			// Perform task that takes less than 2 minutes.
		});
	}

}
