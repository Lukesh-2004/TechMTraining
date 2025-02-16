package lukesh;

import java.io.File;
import java.io.FileNotFoundException;

public class EmptyFileExceptionDemo {
	public static void checkFileEmpty(String filePath) throws Exception {
		File file = new File(filePath);

		if (!file.exists()) {
			throw new FileNotFoundException("File does not exist.");
		}

		if (file.length() == 0) {
			throw new Exception("File is empty!");
		}

		System.out.println("File is not empty.");
	}

	public static void main(String[] args) {
		try {
			checkFileEmpty("empty_file.txt");
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}
}
