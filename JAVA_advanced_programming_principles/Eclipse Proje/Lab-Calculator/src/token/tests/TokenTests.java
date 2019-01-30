package token.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import token.Token;

class TokenTests {

	@Test
	void testIsOperator() {
		Token myTokenOperator = new Token("+");
		Token myTokenNumber = new Token("32");
		assertEquals(true, myTokenOperator.isOperator());
		assertEquals(false, myTokenNumber.isOperator());
	}

}
