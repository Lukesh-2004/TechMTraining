package lukesh;

import java.util.LinkedList;

public class InsertAtFront {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Second");
        list.addFirst("First");

        System.out.println("Updated LinkedList: " + list);
    }
}
