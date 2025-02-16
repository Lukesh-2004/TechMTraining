import java.util.Arrays;
public class AlternativeElementsCopy {
	public static void main(String[] args) {
		// Sample array
		int[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		// Calculate the size of the new array (half of the original array size, rounded
		// up)
		int newSize = (originalArray.length + 1) / 2;

		// Create a new array to store alternative elements
		int[] newArray = new int[newSize];

		// Copy every alternative element from original to new array
		int index = 0;
		for (int i = 0; i < originalArray.length; i += 2) {
			newArray[index++] = originalArray[i];
		}
		// Print the new array
		System.out.println("Original Array: " + Arrays.toString(originalArray));
		System.out.println("New Array with Alternative Elements: " + Arrays.toString(newArray));
	}
}
