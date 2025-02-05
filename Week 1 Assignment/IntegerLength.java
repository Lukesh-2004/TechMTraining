package Week1.utility;

public class IntegerLength {


    public static final String RESULT_MESSAGE = "Length of the given integer: ";

    //Returns the number of digits in a given integer.
    public static int getIntegerLength(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number = number / 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int sampleNumber = 12345;
        System.out.println(RESULT_MESSAGE + getIntegerLength(sampleNumber));
    }
}
