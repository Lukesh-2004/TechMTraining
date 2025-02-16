package lukesh;

import java.util.List;

public class GenericSearch {
	public static <T> int findFirstOccurrence(List<T> list, T target) {
		return list.indexOf(target); // Returns index, -1 if not found
	}

	public static void main(String[] args) {
		List<String> words = List.of("apple", "banana", "cherry", "date");
		System.out.println("Index of 'cherry': " + findFirstOccurrence(words, "cherry")); // Output: 2
		System.out.println("Index of 'grape': " + findFirstOccurrence(words, "grape")); // Output: -1
	}
}
