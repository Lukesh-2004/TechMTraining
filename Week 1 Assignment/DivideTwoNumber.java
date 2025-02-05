package Week1.programs;

import Week1.OOPS.Print;

public class DivideTwoNumber {
    public static void main(String[] args) {
        int dividend = 25;
        int divisor = 5;

        int quotient = 0;
        int tempDividend = dividend;

        while (tempDividend >= divisor) {
            tempDividend -= divisor;
            quotient++;
        }

        int remainder = dividend;
        while (remainder >= divisor) {
            remainder -= divisor;
        }

        System.out.println(Print.QUOTIENT + quotient);
        System.out.println(Print.REMAINDER + remainder);
    }
}
