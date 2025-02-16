import java.util.Scanner;

public class AlternateCaps {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = sc.next();
		sc.close();

		StringBuilder result = new StringBuilder();

		// Loop through each character
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			// Capitalize alternate characters (even index)
			if (i % 2 == 0) {
				result.append(Character.toUpperCase(c));
			} else {
				result.append(Character.toLowerCase(c));
			}
		}

		System.out.println("Transformed String: " + result);
	}
}
