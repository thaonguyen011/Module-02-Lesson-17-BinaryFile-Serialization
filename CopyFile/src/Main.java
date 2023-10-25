import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter source file");
        String sourcePath = scanner.nextLine();

        System.out.println("Enter destination file");
        String desPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File desFile = new File(desPath);

        try {
            copyFileUsingJava7Files(sourceFile, desFile);
//            copyFileUsingStream(sourceFile, desFile);
            System.out.println("Copy completed");
        } catch (IOException e) {
            System.out.println("Can't copy that file");
            System.out.println(e.getMessage());
        }
    }

        private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
          Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        private static void copyFileUsingStream(File source, File des) throws IOException{
            InputStream is = null;
            OutputStream os = null;

            try {
                is = new FileInputStream(source);
                os = new FileOutputStream(des, true);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > -1) {
                    os.write(buffer, 0, length);
                }
            } finally {
                {
                    assert is != null;
                    is.close();
                    assert os != null;
                    os.close();
                }
            }
        }

}