package Week1.objectClassExample;

public class TestingObj {
    public static final String COMPARISON_RESULT = "Comparison Result: ";
    public static final String USER_OBJECT = "User Object: ";
    public static final String SECOND_USER_OBJECT = "SecondUser Object: ";

    public static void main(String[] args) {
        // Creating objextss of User class
        User user1 = new User("Ancy", 25);
        User user2 = new User("Ancy", 25);

        // Creating objects of SecondUser class

        SecondUser secondUser1 = new SecondUser("C Vargeese", 25);
        SecondUser secondUser2 = new SecondUser("C Vagreese", 25);

        // Printing objects

        System.out.println(USER_OBJECT + user1);
        System.out.println(USER_OBJECT + user2);

        System.out.println(SECOND_USER_OBJECT + secondUser1);
        System.out.println(SECOND_USER_OBJECT + secondUser2);

        // Comparing objects

        System.out.println(COMPARISON_RESULT + user1.equals(user2)); //  return true
        System.out.println(COMPARISON_RESULT + (secondUser1 == secondUser2)); // False because of different memory references


    }
}
