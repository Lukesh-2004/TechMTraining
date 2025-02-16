package lukesh;

import java.util.Scanner;

public class ReadConsoleInput {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your name: ");
		String name = scanner.nextLine();

		System.out.println("Hello, " + name + "!");
		scanner.close();
	}
}
