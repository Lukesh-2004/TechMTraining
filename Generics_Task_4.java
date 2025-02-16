package lukesh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericReverse {
	public static <T> List<T> reverseList(List<T> list) {
		List<T> reversed = new ArrayList<>(list);
		Collections.reverse(reversed);
		return reversed;
	}

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
		System.out.println("Reversed List: " + reverseList(numbers)); // Output: [5, 4, 3, 2, 1]
	}
}
