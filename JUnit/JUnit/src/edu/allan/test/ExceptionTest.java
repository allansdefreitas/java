package edu.allan.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExceptionTest {

	@Test
	void shouldThrowException() {
	    Throwable exception = Assertions.assertThrows(UnsupportedOperationException.class, () -> {
	      throw new UnsupportedOperationException("Not supported");
	    });
	    Assertions.assertEquals("Not supported", exception.getMessage());
	}

	@Test
	void shouldThrowExceptionError() {
		Throwable exception = Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			throw new ArrayIndexOutOfBoundsException("Index does not exist");
		});
		Assertions.assertEquals("Not supported", exception.getMessage());
	}

	@Test
	void assertThrowsException() {
	    String str = null;
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	      Integer.valueOf(str);
	    });
	}

	/**
	 * Nothing will be thrown
	 */
	@Test
	void assertThrowsExceptionError() {
		String str = null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Integer.valueOf(10);
		});
	}

}
