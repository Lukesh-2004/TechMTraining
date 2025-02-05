ackage Week1.Final;

public class FinalKeywordExample {

    public static void main(String[] args) {
        // Using the final class
        FinalClassVariable finalClassVariable = new FinalClassVariable();
        System.out.println("Value of G: " + finalClassVariable.getG());
        finalClassVariable.showMessage();

        // Using the final method
        DerivedClass derived = new DerivedClass();
        derived.display();
        derived.showDetails();
    }
}
