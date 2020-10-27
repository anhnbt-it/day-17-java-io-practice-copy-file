import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/27/2020
 * Time: 9:52 AM
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter source file: ");
        String sourcePath = input.nextLine();
        System.out.println("Enter destination file: ");
        String destPath = input.nextLine();
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            if (sourceFile.exists()) {
                copyFileUsingJava7Files(sourceFile, destFile);
                System.out.println("Copy completed.");
            } else {
                System.out.println("File not exists!");
            }
        } catch (IOException e) {
            System.err.println("Can't copy that file");
            e.printStackTrace();
        }
    }

    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        inputStream = new FileInputStream(source);
        outputStream = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }
}
