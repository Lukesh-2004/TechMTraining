package lukesh;

import java.util.LinkedList;

public class InsertAtPosition {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(java.util.List.of("X", "Y", "Z"));
        list.add(1, "A"); // Insert "A" at index 1
        System.out.println("Updated LinkedList: " + list);
    }
}
