package lukesh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleArrayList {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
		Collections.shuffle(numbers);
		System.out.println("Shuffled List: " + numbers);
	}
}
