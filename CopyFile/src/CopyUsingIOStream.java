import java.io.*;
import java.nio.file.FileAlreadyExistsException;


public class CopyUsingIOStream {

    public static void main(String[] args) {


        File sourceFile = new File("/Users/apple/Desktop/Codegym /Module-02-Java/17-BinaryFile-Serialization/CopyFile/src/Hello.dat");
        File desFile = new File("/Users/apple/Desktop/Codegym /Module-02-Java/17-BinaryFile-Serialization/CopyFile/src/Hello01000.dat");
//        readFileText(sourceFile);

        copyFileUsingStream(sourceFile, desFile);

    }


    private static void copyFileUsingStream(File source, File des) {
        try {
            if (!source.exists()) {
                throw new FileNotFoundException();
            }
            if (des.exists()) {
                throw new FileAlreadyExistsException(des.getName());
            }
            InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(des, true);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > -1) {
                os.write(buffer, 0, length);
            }
            System.out.println("Copy completed");
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readFileText(File file) {
        try {


//            if (!file.exists()) {
//                throw new FileNotFoundException();
//            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();

            System.out.println("Tổng = " + sum);
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }


}
