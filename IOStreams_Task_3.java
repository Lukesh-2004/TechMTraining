package lukesh;

import java.io.File;

public class CheckFileExistence {
	public static void main(String[] args) {
		String path = "C:\\Users\\Public\\example.txt"; // Change as needed
		File file = new File(path);

		if (file.exists()) {
			System.out.println("File/Directory exists.");
		} else {
			System.out.println("File/Directory does not exist.");
		}
	}
}
