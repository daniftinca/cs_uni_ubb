package logic.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;

import logic.ShuntingYard;
import token.OperatorToken;
import token.Token;

class ShuntingYardTest {

	@Test
	void testGetShuntingYardOutput() {
		Stack<Token> input = new Stack<Token>();
		Stack<Token> output = new Stack<Token>();
		Stack<Token> expectedOutput = new Stack<Token>();
		
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

 		output = ShuntingYard.getShuntingYardOutput(input);
 		
	
	
		expectedOutput.push(new Token("3"));
		expectedOutput.push(new Token("4"));
		expectedOutput.push(new Token("2"));
		expectedOutput.push(new Token("5"));
		expectedOutput.push(new Token("1"));
		expectedOutput.push(new Token("5"));
		expectedOutput.push(new OperatorToken("-"));
		expectedOutput.push(new OperatorToken("*"));
		expectedOutput.push(new OperatorToken("/"));
		expectedOutput.push(new OperatorToken("*"));
		expectedOutput.push(new OperatorToken("+"));
	
		assertEquals(output, expectedOutput);
		
	}

}
