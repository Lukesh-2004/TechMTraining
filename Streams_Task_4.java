package lukesh;
import java.util.List;
import java.util.stream.Collectors;

public class StreamRemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5, 5, 6);

        List<Integer> uniqueNumbers = numbers.stream()
                                             .distinct()
                                             .collect(Collectors.toList());

        System.out.println("Unique Numbers: " + uniqueNumbers);
    }
}
