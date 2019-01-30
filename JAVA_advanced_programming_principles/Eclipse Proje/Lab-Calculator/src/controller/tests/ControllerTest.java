/**
 * 
 */
package controller.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;

import controller.Controller;
import token.NumberToken;
import token.OperatorToken;
import token.Token;

/**
 * @author Dan
 *
 */
class ControllerTest {

	/**
	 * Test method for {@link controller.Controller#parseStringToStack(java.lang.String)}.
	 */
	@Test
	void testParseStringToStack() {
		String input = "2+(3-2)";
		Stack<Token> expectedOut = new Stack<Token>();

		expectedOut.push(new OperatorToken(")"));
		expectedOut.push(new NumberToken("2"));
		expectedOut.push(new OperatorToken("-"));
		expectedOut.push(new NumberToken("3"));
		expectedOut.push(new OperatorToken("("));
		expectedOut.push(new OperatorToken("+"));
		expectedOut.push(new NumberToken("2"));
		Stack<Token> actual = Controller.parseStringToStack(input);
		assertEquals(expectedOut, actual);
	}

	/**
	 * Test method for {@link controller.Controller#solveProblem(java.lang.String)}.
	 */
	@Test
	void testSolveProblem() {
		String input = "(1+2+7)/2*(3-1)";
		double expected = 10;
		double actual = Controller.solveProblem(input);
		assertEquals(expected, actual);
		
	}

}
