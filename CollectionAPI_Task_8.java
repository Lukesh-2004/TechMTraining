package lukesh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortArrayList {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(List.of(42, 23, 56, 12, 8));
		Collections.sort(numbers); // Sort in ascending order
		System.out.println("Sorted List: " + numbers);
	}
}
