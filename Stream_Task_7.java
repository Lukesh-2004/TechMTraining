package lukesh;

import java.util.List;
import java.util.Optional;

public class StreamMaxMin {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(15, 42, 7, 89, 33);

        Optional<Integer> max = numbers.stream().max(Integer::compare);
        Optional<Integer> min = numbers.stream().min(Integer::compare);

        System.out.println("Maximum: " + max.orElse(-1));
        System.out.println("Minimum: " + min.orElse(-1));
    }
}
