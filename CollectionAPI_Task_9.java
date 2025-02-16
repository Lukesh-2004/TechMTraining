package lukesh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CopyArrayList {
	public static void main(String[] args) {
		List<String> source = new ArrayList<>(List.of("A", "B", "C"));
		List<String> destination = new ArrayList<>(Collections.nCopies(source.size(), "")); // Create empty list

		Collections.copy(destination, source);
		System.out.println("Copied List: " + destination);
	}
}
