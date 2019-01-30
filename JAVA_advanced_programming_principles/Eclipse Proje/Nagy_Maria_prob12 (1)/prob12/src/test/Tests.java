package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algorithms.ExOne;
import algorithms.ExTwo;

class Tests {

	@Test
	public void rotateMatrixClockwiseTest() {

		ExOne matrixObj = new ExOne(3);

		int[][] matr1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		matrixObj.setMatrix(matr1);
		matrixObj.rotateMatrixClockwise();

		int[][] resultMatrix = matrixObj.getMatrix();
		int[][] testMatrix = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };

		assertArrayEquals(testMatrix, resultMatrix);

	}

	@Test
	public void shiftArrayTest() {

		ExTwo ex2Obj = new ExTwo(5);
		int[] arr1 = { 1, 2, 3, 4, 5 };
		ex2Obj.setSortedArray(arr1);
		ex2Obj.shiftArray(2);
		int[] result = ex2Obj.getSortedArray();
		int[] test = { 4, 5, 1, 2, 3 };
		assertArrayEquals(test, result);

	}

	@Test
	public void getShiftedArrayNrIndex() {

		ExTwo ex2Obj = new ExTwo(5);
		int[] arr1 = { 1, 2, 3, 4, 5 };
		ex2Obj.setSortedArray(arr1);
		ex2Obj.shiftArray(2);
		int result = ex2Obj.getShiftedArrayNrIndex(2, 0, 4);
		int test = 3;

		assertEquals(test, result);

	}

}
