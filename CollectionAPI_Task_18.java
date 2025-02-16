package lukesh;

import java.util.LinkedList;

public class InsertAtEnd {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(java.util.List.of(1, 2, 3));
        list.addLast(4);

        System.out.println("Updated LinkedList: " + list);
    }
}
