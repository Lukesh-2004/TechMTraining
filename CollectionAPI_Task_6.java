package lukesh;

import java.util.ArrayList;
import java.util.List;

public class RemoveThirdElement {
	public static void main(String[] args) {
		List<String> languages = new ArrayList<>(List.of("Java", "Python", "C++", "JavaScript"));
		languages.remove(2); // Remove C++
		System.out.println("Updated List: " + languages);
	}
}
