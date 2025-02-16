package siva;

import java.util.LinkedList;
import java.util.List;

public class InsertMultipleElements {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>(List.of("A", "B", "E"));

		// List of elements to insert
		LinkedList<String> newElements = new LinkedList<>(List.of("C", "D"));

		// Insert elements at index 2
		list.addAll(2, newElements);

		System.out.println("Updated LinkedList: " + list);
	}
}
