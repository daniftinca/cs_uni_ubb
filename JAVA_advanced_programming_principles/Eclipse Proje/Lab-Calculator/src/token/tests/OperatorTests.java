package token.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import token.OperatorToken;

class OperatorTests {

	@Test
	void test() {
		OperatorToken myTokenNumber = new OperatorToken("+");
		assertEquals(1, myTokenNumber.getPrecedence());
		OperatorToken myTokenNumber1 = new OperatorToken("-");
		assertEquals(1, myTokenNumber1.getPrecedence());
		OperatorToken myTokenNumber2 = new OperatorToken("*");
		assertEquals(2, myTokenNumber2.getPrecedence());
		OperatorToken myTokenNumber3 = new OperatorToken("/");
		assertEquals(2, myTokenNumber3.getPrecedence());
		OperatorToken myTokenNumber4 = new OperatorToken("(");
		assertEquals(0, myTokenNumber4.getPrecedence());
		OperatorToken myTokenNumber5 = new OperatorToken(")");
		assertEquals(0, myTokenNumber5.getPrecedence());
	}

}
