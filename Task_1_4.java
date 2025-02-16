import java.util.Arrays;

public class ArrayCopyRangeExample {
	public static void main(String[] args) {
		// Original array
		int[] numbers = { 10, 20, 30, 40, 50, 60 };

		// Copying elements from index 1 to 4 (excluding 4)
		int[] copiedArray = Arrays.copyOfRange(numbers, 1, 4);

		// Display copied array
		System.out.println("Original Array: " + Arrays.toString(numbers));
		System.out.println("Copied Array: " + Arrays.toString(copiedArray));
	}
}
