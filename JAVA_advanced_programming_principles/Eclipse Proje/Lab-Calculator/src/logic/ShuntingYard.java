/**
 * 
 */
package logic;

import java.util.Stack;

import token.OperatorToken;
import token.Token;

/**
 * @author Dan
 *
 * Eine Klasse die der Shunting Yard Algorithmus enkapselt.
 */
public abstract class ShuntingYard {
	
	/**
	 * Statische Methode, dass einen Stack von Tokens als Paramether nimmt und das ShuntingYard Algorithmus auf diese implementiert.
	 * @param input - Stack mit Tokens
	 * @return - Stack fur das Reverse Polish Algorithm.
	 */
	public static Stack<Token> getShuntingYardOutput(Stack<Token> input) {
		Stack<Token> output = new Stack<Token>();
		Stack<OperatorToken> operator = new Stack<OperatorToken>();
 		
		while(!input.empty()) {
			
			if(!input.peek().isOperator()) {
				output.push(input.pop());
			}else if(input.peek().getValue().equals(")")) {
				input.pop();
				while(!operator.empty() &&!operator.peek().getValue().equals("(")) {
					output.push(operator.pop());
				} 
				operator.pop();

			} else if(input.peek().getValue().equals("(")) {
				operator.push(new OperatorToken(input.pop().getValue()));
			} else {
				
				OperatorToken currentOperator = new OperatorToken(input.pop().getValue());
				
					while(!operator.empty() && operator.peek().getPrecedence() >= currentOperator.getPrecedence()) {
						
						output.push(operator.pop());
					} 
				
				operator.push(currentOperator);
			}
		}
		while(!operator.empty()) {
			output.push(operator.pop());
		}
		
		return output;
	}
	
}
