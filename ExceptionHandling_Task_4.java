package lukesh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PositiveNumberExceptionDemo {
	public static void checkFileNumbers(String filePath) throws Exception {
		File file = new File(filePath);
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextInt()) {
			int num = scanner.nextInt();
			if (num > 0) {
				scanner.close();
				throw new Exception("File contains a positive number: " + num);
			}
		}
		scanner.close();
		System.out.println("No positive numbers found.");
	}

	public static void main(String[] args) {
		try {
			checkFileNumbers("numbers.txt");
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}
}
