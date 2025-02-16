package lukesh;

import java.util.LinkedList;

public class FirstLastOccurrence {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>(java.util.List.of("Apple", "Banana", "Cherry", "Banana", "Date"));

		// Get first and last occurrence of "Banana"
		int firstIndex = list.indexOf("Banana");
		int lastIndex = list.lastIndexOf("Banana");

		System.out.println("First occurrence of 'Banana': " + firstIndex);
		System.out.println("Last occurrence of 'Banana': " + lastIndex);
	}
}
