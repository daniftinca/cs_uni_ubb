package token.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import token.NumberToken;

class NumberTests {

	@Test
	void testGetDouble() {
		NumberToken myTokenNumber = new NumberToken("32");
		assertEquals(32.0, myTokenNumber.getDouble());
	}

}
