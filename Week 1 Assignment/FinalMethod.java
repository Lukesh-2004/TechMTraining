package Week1.Final;

// A final method that cannot be overridden.
public class FinalMethod {

    public final void display() {
        System.out.println("This is a final method in a non-final class.");
    }
}

class DerivedClass extends FinalMethod {
    //Cannot override display() because it is final
    // Displays a message from the derived class.

    public void showDetails() {
        System.out.println("This is a method inside the derived class.");
    }
}
