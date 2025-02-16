package lukesh;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileToByteArray {
	public static void main(String[] args) {
		String filePath = "C:\\Users\\Public\\example.txt"; // Change as needed
		File file = new File(filePath);

		try (FileInputStream fis = new FileInputStream(file)) {
			byte[] data = new byte[(int) file.length()];
			fis.read(data);

			System.out.println("File Content in Bytes: ");
			for (byte b : data) {
				System.out.print((char) b);
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
}
