package console;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

import algorithms.ExOne;
import algorithms.ExTwo;

public class Demo {

	public Demo() {

	}

	public static void main(String args[]) {

		while (true) {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Enter the number of the problem (1 or 2): ");
			int problemNr = keyboard.nextInt();
			if (problemNr == 1) {
				int matrixSize = 4;

				ExOne obj = new ExOne(matrixSize);

				obj.fillMatrixRandom(16);
				System.out.println("Initial Matrix:\n");
				obj.printMatrix();
				System.out.println("\n");
				obj.rotateMatrixClockwise();
				System.out.println("Result Matrix:\n");
				obj.printMatrix();
				System.out.println("\n");
			} else {

				ExTwo arrayObj = new ExTwo();
				int[] array1 = { 1, 3, 4, 5, 9 };
				System.out.println("Initial array: " + Arrays.toString(array1));

				arrayObj.setSortedArray(array1);

				System.out.println("Enter number of shifts: ");
				int nrOfShifts = keyboard.nextInt();
				arrayObj.shiftArray(nrOfShifts);

				int[] shiftedArray = arrayObj.getSortedArray();
				System.out.println(
						"Array shifted " + nrOfShifts + " times to the right: " + Arrays.toString(shiftedArray));

				while (true) {
					System.out.println("Choose the target number: ");
					int targetNr = keyboard.nextInt();
					boolean contains = IntStream.of(shiftedArray).anyMatch(x -> x == targetNr);
					if (contains == true) {
						int getIndex = arrayObj.getShiftedArrayNrIndex(targetNr, 0, 4);
						System.out.println("The index of the target number is: " + getIndex + "\n");
						break;
					} else {
						System.out.println("Number not in array. Please try again.");
					}
				}

			}
		}
	}

}
