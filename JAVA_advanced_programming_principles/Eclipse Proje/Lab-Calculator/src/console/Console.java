/**
 * 
 */
package console;

import java.util.Scanner;

import controller.Controller;

/**
 * @author Dan
 *
 */
public class Console {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		while(true) {
			String inputString = keyboard.nextLine();
			System.out.println(Controller.solveProblem(inputString));
		}
	}

}
