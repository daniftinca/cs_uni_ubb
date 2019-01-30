package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ExOne {

	private int[][] matrix;

	public ExOne(int n) {
		matrix = new int[n][n];
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	/**
	 * Fills matrix with random, distinct numbers
	 * 
	 * @param n
	 */
	public void fillMatrixRandom(int n) {

		Random rng = new Random();
		Set<Integer> generated = new LinkedHashSet<Integer>();
		while (generated.size() < n) {
			Integer next = rng.nextInt(n);
			generated.add(next);
		}

		List<Integer> generatedList = new ArrayList<Integer>(generated);

		int ctRandomNumbers = 0;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix.length; col++) {
				matrix[row][col] = generatedList.get(ctRandomNumbers);

				ctRandomNumbers++;
			}

		}

	}

	/**
	 * Displays matrix
	 */
	public void printMatrix() {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix.length; col++)
				System.out.print(" " + matrix[row][col]);
			System.out.print("\n");
		}

	}

	/**
	 * Rotates matrix clockwise
	 */
	public void rotateMatrixClockwise() {
		int maxIndex = matrix.length - 1;

		for (int row = 0; row < matrix.length / 2; row++) {
			for (int col = row; col < maxIndex - row; col++) {

				int aux = matrix[row][col];
				matrix[row][col] = matrix[maxIndex - col][row];
				matrix[maxIndex - col][row] = matrix[maxIndex - row][maxIndex - col];
				matrix[maxIndex - row][maxIndex - col] = matrix[col][maxIndex - row];
				matrix[col][maxIndex - row] = aux;
			}
		}
	}

	@Override
	public String toString() {
		return "ExOne [matrix=" + Arrays.toString(matrix) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matrix);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExOne other = (ExOne) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		return true;
	}

}
