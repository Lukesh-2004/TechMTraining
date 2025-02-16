package lukesh;

import java.io.File;
import java.io.FilenameFilter;

public class FilterFilesByExtension {
	public static void main(String[] args) {
		String directoryPath = "C:\\Users\\Public"; // Change path
		String extension = ".txt"; // Change to required extension

		File directory = new File(directoryPath);

		if (directory.exists() && directory.isDirectory()) {
			FilenameFilter filter = (dir, name) -> name.endsWith(extension);
			File[] files = directory.listFiles(filter);

			System.out.println("Files with " + extension + " extension:");
			for (File file : files) {
				System.out.println(file.getName());
			}
		} else {
			System.out.println("Invalid directory path.");
		}
	}
}
