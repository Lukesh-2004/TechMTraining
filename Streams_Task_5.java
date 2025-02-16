package lukesh;

import java.util.List;

public class StreamCountByLetter {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Andrew", "Bob", "Amanda", "Brian");

        long count = names.stream()
                          .filter(name -> name.startsWith("A"))
                          .count();

        System.out.println("Number of names starting with 'A': " + count);
    }
}
