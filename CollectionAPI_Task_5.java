package lukesh;

import java.util.ArrayList;
import java.util.List;

public class UpdateElement {
	public static void main(String[] args) {
		List<String> cities = new ArrayList<>(List.of("New York", "Paris", "Tokyo"));
		cities.set(1, "London"); // Update Paris to London
		System.out.println("Updated List: " + cities);
	}
}
