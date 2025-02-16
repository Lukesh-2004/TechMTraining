package lukesh;

import java.util.ArrayList;
import java.util.List;

public class RetrieveElement {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30, 40));
		System.out.println("Element at index 2: " + numbers.get(2)); // Output: 30
	}
}
