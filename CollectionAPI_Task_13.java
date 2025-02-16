package siva;

import java.util.LinkedList;
import java.util.ListIterator;

public class IterateFromPosition {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>(java.util.List.of("A", "B", "C", "D", "E"));

		ListIterator<String> iterator = list.listIterator(2); // Start at index 2
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
