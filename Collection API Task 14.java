package lukesh;

import java.util.LinkedList;
import java.util.Iterator;

public class ReverseIterateLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(java.util.List.of("One", "Two", "Three"));

        Iterator<String> iterator = list.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
