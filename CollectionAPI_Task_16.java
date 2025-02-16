package lukesh;


import java.util.LinkedList;

public class InsertFirstLast {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(10);
        list.addLast(50);

        System.out.println("Updated LinkedList: " + list);
    }
}
