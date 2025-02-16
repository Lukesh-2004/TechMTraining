package lukesh;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSort {
    public static void main(String[] args) {
        List<String> words = List.of("banana", "apple", "cherry", "date");

        List<String> ascending = words.stream()
                                      .sorted()
                                      .collect(Collectors.toList());

        List<String> descending = words.stream()
                                       .sorted((a, b) -> b.compareTo(a))
                                       .collect(Collectors.toList());

        System.out.println("Ascending Order: " + ascending);
        System.out.println("Descending Order: " + descending);
    }
}
