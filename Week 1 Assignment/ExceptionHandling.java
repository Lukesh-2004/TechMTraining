package Week1;

import Week1.OOPS.Print;

import java.util.Scanner;

public class ExceptionHandlings {

    public void processInput() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println(Print.ENTER_NUMBER);
            double userInput = sc.nextInt();
            //  input is not zero to prevent division error
            if (userInput == 0) {
                System.out.println(Print.DIVIDE_BY_ZERO);
            } else {
                double reciprocal = 1 / userInput;
                System.out.println(Print.RECIPROCAL_IS + reciprocal);
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println(Print.INVALID_INPUT);
        }
    }

    public static void main(String[] args) {
        ExceptionHandlings exceptionHandlings = new ExceptionHandlings();
        exceptionHandlings.processInput();

    }
}
