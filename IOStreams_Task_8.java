package lukesh;

import java.io.File;

public class FileSize {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Public\\example.txt"; // Change as needed
        File file = new File(filePath);

        if (file.exists()) {
            long sizeInBytes = file.length();
            double sizeInKB = sizeInBytes / 1024.0;
            double sizeInMB = sizeInKB / 1024.0;

            System.out.println("File Size:");
            System.out.println("Bytes: " + sizeInBytes);
            System.out.println("KB: " + sizeInKB);
            System.out.println("MB: " + sizeInMB);
        }
    }
}
