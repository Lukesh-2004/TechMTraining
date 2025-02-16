import java.util.Scanner;

public class OddNumberExceptionDemo {
	public static void checkEven(int number) throws Exception {
		if (number % 2 != 0) {
			throw new Exception("Odd number is not allowed!");
		}
		System.out.println("Valid number: " + number);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number : ");
		int number = sc.nextInt();
		try {
			checkEven(number); // This will throw an exception
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}
}
