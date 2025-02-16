package lukesh;

import java.util.Arrays;

public class GenericArrayComparison {
	public static <T> boolean areArraysEqual(T[] arr1, T[] arr2) {
		return Arrays.equals(arr1, arr2); // Checks if both arrays are identical
	}

	public static void main(String[] args) {
		Integer[] array1 = { 1, 2, 3, 4 };
		Integer[] array2 = { 1, 2, 3, 4 };
		Integer[] array3 = { 1, 2, 4, 3 };

		System.out.println("Array1 and Array2 are equal: " + areArraysEqual(array1, array2)); // true
		System.out.println("Array1 and Array3 are equal: " + areArraysEqual(array1, array3)); // false
	}
}
