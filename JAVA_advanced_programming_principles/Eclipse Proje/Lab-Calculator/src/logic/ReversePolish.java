/**
 * 
 */
package logic;

import java.util.Stack;

import token.NumberToken;
import token.Token;

/**
 * @author Dan
 * Eine Klasse die der Shunting Yard Algorithmus enkapselt.  
 */
public class ReversePolish {

	/**
	 * Liefert das Resultat nachdem den Reverse Polish Algorithm auf einen Stack benutzt wird.
	 * @param input einen Stack mit Tokens.
	 * @return double
	 */
	public static double getReversePolishOutput(Stack<Token> input) {
		double finalResult = 0;
		Stack<Token> auxiliaryStack = new Stack<Token>();
		boolean firstSwitch = true;
		double res;
		while(!input.empty()) {
			
			if(!input.peek().isOperator()) {
				auxiliaryStack.push(input.pop());
			}
			else {
				
				if(firstSwitch) {
					NumberToken firstValue = new NumberToken(auxiliaryStack.pop().getValue());
					double num1 = firstValue.getDouble();
					double num2 = 0;
					res = num1+num2;
					auxiliaryStack.push(new NumberToken(Double.toString(res)));
					firstSwitch = false;
				}
				
				if(input.peek().getValue().equals("+")) {
					NumberToken number1 = new NumberToken(auxiliaryStack.pop().getValue());
					NumberToken number2 = new NumberToken(auxiliaryStack.pop().getValue());
					res = number2.getDouble() + number1.getDouble();
					auxiliaryStack.push(new NumberToken(Double.toString(res)));
					input.pop();
				} else if(input.peek().getValue().equals("-")) {
					NumberToken number1 = new NumberToken(auxiliaryStack.pop().getValue());
					NumberToken number2 = new NumberToken(auxiliaryStack.pop().getValue());
					res = number2.getDouble() - number1.getDouble();
					auxiliaryStack.push(new NumberToken(Double.toString(res)));
					input.pop();
				} else if(input.peek().getValue().equals("*")) {
					NumberToken number1 = new NumberToken(auxiliaryStack.pop().getValue());
					NumberToken number2 = new NumberToken(auxiliaryStack.pop().getValue());
					res = number2.getDouble() * number1.getDouble();
					auxiliaryStack.push(new NumberToken(Double.toString(res)));
					input.pop();
				} else if(input.peek().getValue().equals("/")) {
					NumberToken number1 = new NumberToken(auxiliaryStack.pop().getValue());
					NumberToken number2 = new NumberToken(auxiliaryStack.pop().getValue());
					res = number2.getDouble() / number1.getDouble();
					auxiliaryStack.push(new NumberToken(Double.toString(res)));
					input.pop();
				}
				
			}
		}
		finalResult = ((NumberToken) auxiliaryStack.pop()).getDouble();
		return finalResult;
	}
}
