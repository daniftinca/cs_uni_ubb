/**
 * 
 */
package logic.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import logic.ReversePolish;
import logic.ShuntingYard;
import token.Token;

/**
 * @author Dan
 *
 */
class ReversePolishTests {

	/**
	 * Test method for {@link logic.ReversePolish#getReversePolishOutput(java.util.Stack)}.
	 */
	@Test
	void testGetReversePolishOutput() {
		Stack<Token> input = new Stack<Token>();
		Stack<Token> syOutput = new Stack<Token>();
		double expectedOutput;

		
		
		//3+4*2/5(1-5)
		input.push(new Token(")"));
		input.push(new Token("5"));
		input.push(new Token("-"));
		input.push(new Token("1"));
		input.push(new Token("("));
		input.push(new Token("*"));
		input.push(new Token("5"));
		input.push(new Token("/"));
		input.push(new Token("2"));
		input.push(new Token("*"));
		input.push(new Token("4"));
		input.push(new Token("+")); 
		input.push(new Token("3"));

 		syOutput = ShuntingYard.getShuntingYardOutput(input);
 		Collections.reverse(syOutput); 
 		expectedOutput = ReversePolish.getReversePolishOutput(syOutput);
 		assertEquals(expectedOutput, 2.6);
	}

}
