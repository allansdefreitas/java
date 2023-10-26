package edu.allan.test;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AssumptionsTest {

	
	 @Test
	 void groupAssertions() {
	     int[] numbers = {0, 1, 2, 3, 4};
	     Assertions.assertAll("numbers",
	         () -> Assertions.assertEquals(numbers[1], 1),
	         () -> Assertions.assertEquals(numbers[3], 3),
	         () -> Assertions.assertEquals(numbers[4], 4)
	     );
	 }

}
