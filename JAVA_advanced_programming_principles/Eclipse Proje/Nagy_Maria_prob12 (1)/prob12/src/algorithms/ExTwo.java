package algorithms;

public class ExTwo {

	int[] sortedArray;

	public ExTwo() {
	}

	public ExTwo(int n) {
		sortedArray = new int[n];
	}

	public int[] getSortedArray() {
		return sortedArray;
	}

	public void setSortedArray(int[] sortedArray) {
		this.sortedArray = sortedArray;
	}

	/**
	 * Shifts array to the right
	 * 
	 * @param n
	 *            is number of shifts
	 */
	public void shiftArray(int n) {

		while (n > 0) {
			int last = sortedArray[sortedArray.length - 1];

			for (int index = sortedArray.length - 2; index >= 0; index--) {
				sortedArray[index + 1] = sortedArray[index];

			}
			sortedArray[0] = last;
			n--;
		}

	}

	/**
	 * Returns target element index
	 * 
	 * @param array
	 * @param targetNr
	 * @param left
	 * @param right
	 * @return
	 */
	public int binSearch(int[] array, int targetNr, int left, int right) {

		int middle = left + (right - left) / 2;
		if (targetNr == array[middle]) {
			return middle;

		} else if (targetNr < array[middle]) {

			return binSearch(array, targetNr, left, middle - 1);
		} else {
			return binSearch(array, targetNr, middle + 1, right);
		}
	}

	/**
	 * Returns position of the target element in shifted array
	 * 
	 * @param targetNr
	 * @param left
	 * @param right
	 * @param shiftNr
	 * @return
	 */
	public int getShiftedArrayNrIndex(int targetNr, int left, int right) {

		int middle = left + (right - left) / 2;
		if (targetNr == sortedArray[middle]) {
			return middle;
		} else if (sortedArray[middle] < sortedArray[right]) {
			if ((targetNr > sortedArray[middle]) && (targetNr <= sortedArray[right])) {
				return binSearch(sortedArray, targetNr, middle + 1, right);

			} else {
				return getShiftedArrayNrIndex(targetNr, left, middle - 1);
			}

		} else {
			if ((targetNr >= sortedArray[left]) && (targetNr < sortedArray[middle])) {
				return binSearch(sortedArray, targetNr, left, middle - 1);

			} else {
				return getShiftedArrayNrIndex(targetNr, middle + 1, right);
			}

		}
	}

}
