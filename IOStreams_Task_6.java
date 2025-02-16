package lukesh;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LastModifiedDate {
	public static void main(String[] args) {
		String filePath = "C:\\Users\\Public\\example.txt"; // Change as needed
		File file = new File(filePath);

		if (file.exists()) {
			long lastModified = file.lastModified();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			System.out.println("Last Modified Date: " + sdf.format(new Date(lastModified)));
		} else {
			System.out.println("File does not exist.");
		}
	}
}
