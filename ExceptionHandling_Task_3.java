package lukesh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileNotFoundExceptionExample {
	public static void readFile(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
	}

	public static void main(String[] args) {
		try {
			readFile("non_existent_file.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Exception: File not found!");
		}
	}
}
