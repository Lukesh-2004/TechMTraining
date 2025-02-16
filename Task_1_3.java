import java.util.Arrays;
import java.util.Objects;

public class EqualsVsDeepEquals {
	public static void main(String[] args) {
		// Two identical integer arrays
		Integer[] arr1 = { 1, 2, 3 };
		Integer[] arr2 = { 1, 2, 3 };

		// Using equals() -> Compares reference, not content
		System.out.println("Using equals(): " + Arrays.equals(arr1, arr2)); // true (content comparison for arrays)

		// Using deepEquals() -> Compares nested structures
		Object[] nestedArr1 = { arr1 };
		Object[] nestedArr2 = { arr2 };
		System.out.println("Using deepEquals(): " + Arrays.deepEquals(nestedArr1, nestedArr2)); // true (deep
																								// comparison)

		// Objects.equals() for simple objects
		System.out.println("Objects.equals(): " + Objects.equals(arr1, arr2)); // false (compares references)
	}
}
