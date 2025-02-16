package lukesh;

import java.util.LinkedList;

public class AppendToLinkedList {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.add("Red");
		list.add("Blue");
		list.add("Green");

		list.addLast("Yellow"); // Append to the end
		System.out.println("Updated LinkedList: " + list);
	}
}
