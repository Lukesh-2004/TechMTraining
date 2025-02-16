package lukesh;

import java.io.File;

public class CheckFileOrDirectory {
	public static void main(String[] args) {
		String path = "C:\\Users\\Public"; // Change as needed
		File file = new File(path);

		if (file.exists()) {
			if (file.isDirectory()) {
				System.out.println("It is a directory.");
			} else {
				System.out.println("It is a file.");
			}
		} else {
			System.out.println("Path does not exist.");
		}
	}
}
