package Week1.programs;

public class TrailingZerosInFactorial {
    // N=User Input
    public static void main(String[] args) {


        int n = 925;
        // Count= No of trailing Zeros

        int count = 0;
        //Divide n by powes of 5 and add its quotient to count
        while (n >= 5) {
            n = n / 5;
            count = count + n;
        }
        System.out.println(count);
    }
}
