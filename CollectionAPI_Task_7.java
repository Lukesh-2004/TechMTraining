package lukesh;

import java.util.ArrayList;
import java.util.List;

public class SearchArrayList {
	public static void main(String[] args) {
		List<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Cherry"));

		String search = "Banana";
		if (fruits.contains(search)) {
			System.out.println(search + " found at index: " + fruits.indexOf(search));
		} else {
			System.out.println(search + " not found.");
		}
	}
}
