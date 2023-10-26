package edu.allan.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class AssertionsTest {

	
	@Test
	void trueAssumption() {
		Assumptions.assumeTrue(5 > 1);
		Assertions.assertEquals(5 + 2, 7);
	}

	/**
	 * This test is not ran
	 */
	@Test
	void trueAssumptionNotRun() {
		Assumptions.assumeTrue(5 > 10);
		Assertions.assertEquals(5 + 2, 7);
	}

	@Test
	void falseAssumption() {
		Assumptions.assumeFalse(5 < 1);
		Assertions.assertEquals(5 + 2, 7);
	}

	@Test
	void assumptionThat() {
		
	    String someString = "Just a string";
	    Assumptions.assumingThat(
	        someString.equals("Just a string"),
	        () -> Assertions.assertEquals(2 + 2, 4)
	    );
	}

}
