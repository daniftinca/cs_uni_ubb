/**
 *
 */
package controller;

import java.util.Collections;
import java.util.Stack;

import logic.ReversePolish;
import logic.ShuntingYard;
import token.NumberToken;
import token.OperatorToken;
import token.Token;

/**
 * @author Dan
 * Klasse die auxiliaere Funktionen enthaelt.
 */
public class Controller {
	
	
	/**
	 * Macht aus einen String einen Stack mit Tokens.
	 * @param input
	 * @return Stack
	 */
	public static Stack<Token> parseStringToStack(String input) {
		String numString = "";
		String opString = "";
		Stack<Token> resultStack = new Stack<Token>();
		
		for(int i = 0; i< input.length();i++) {
			if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/' || input.charAt(i) == '(' || input.charAt(i) == ')') {
				if(!numString.equals(""))
					resultStack.push(new NumberToken(numString));
				opString += input.charAt(i);
				resultStack.push(new OperatorToken(opString));
				
				numString = "";
				opString = "";
			} else {
				numString += input.charAt(i);
			}
		}
		if(!numString.equals(""))
			resultStack.push(new NumberToken(numString));
		
		Collections.reverse(resultStack);
		return resultStack;
	};
	
	/**
	 * Liefert das Endresultat.
	 * @param input
	 * @return Endresultat.
	 */
	public static double solveProblem(String input) {
		Stack<Token> myInput = parseStringToStack(input);
		Stack<Token> syStack = ShuntingYard.getShuntingYardOutput(myInput);
		Collections.reverse(syStack);
		double result = ReversePolish.getReversePolishOutput(syStack);
		return result;
	}
}
