package lukesh;

import java.util.ArrayList;
import java.util.List;

public class InsertAtFirst {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>(List.of("John", "Alice", "Bob"));
		names.add(0, "Mike"); // Insert "Mike" at index 0
		System.out.println("Updated List: " + names);
	}
}
