package lukesh;

import java.io.File;

public class CheckFilePermissions {
	public static void main(String[] args) {
		String filePath = "C:\\Users\\Public\\example.txt"; // Change as needed
		File file = new File(filePath);

		if (file.exists()) {
			System.out.println("Readable: " + file.canRead());
			System.out.println("Writable: " + file.canWrite());
		} else {
			System.out.println("File does not exist.");
		}
	}
}
