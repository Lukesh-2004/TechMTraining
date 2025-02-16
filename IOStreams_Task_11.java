package lukesh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFile {
	public static void main(String[] args) {
		String filePath = "C:\\Users\\Public\\example.txt"; // Change as needed

		File file = new File(filePath);

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		}
	}
}
