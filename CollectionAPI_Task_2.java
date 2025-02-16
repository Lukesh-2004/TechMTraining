import java.util.ArrayList;
import java.util.List;

public class IterateArrayList {
	public static void main(String[] args) {
		List<String> items = new ArrayList<>(List.of("Apple", "Banana", "Cherry"));

		for (String item : items) {
			System.out.println(item);
		}
	}
}
