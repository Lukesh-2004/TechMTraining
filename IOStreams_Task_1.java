package lukesh;

import java.io.File;

public class ListFiles1 {
	public static void main(String[] args) {
		String directoryPath = "C:\\Users\\Public"; // Change this to your desired directory path

		File directory = new File(directoryPath);

		if (directory.exists() && directory.isDirectory()) {
			String[] files = directory.list();
			System.out.println("Files and Directories in " + directoryPath + ":");
			for (String file : files) {
				System.out.println(file);
			}
		} else {
			System.out.println("Invalid directory path.");
		}
	}
}
