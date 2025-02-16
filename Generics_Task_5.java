package lukesh;

import java.util.ArrayList;
import java.util.List;

public class GenericMerge {
	public static <T> List<T> mergeLists(List<T> list1, List<T> list2) {
		List<T> merged = new ArrayList<>();
		int i = 0, j = 0;

		while (i < list1.size() || j < list2.size()) {
			if (i < list1.size())
				merged.add(list1.get(i++));
			if (j < list2.size())
				merged.add(list2.get(j++));
		}
		return merged;
	}

	public static void main(String[] args) {
		List<String> list1 = List.of("A", "B", "C");
		List<String> list2 = List.of("1", "2", "3", "4");

		System.out.println("Merged List: " + mergeLists(list1, list2));
		// Output: [A, 1, B, 2, C, 3, 4]
	}
}
