import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadBYConsole {
    public static void main(String[] args) throws Exception{
        InputStream is = System.in;

        while(true) {
            System.out.println("Enter 1 character");
            int ch = is.read();
            System.out.println(ch);
            if (ch == 'q') {
                System.out.println("Finished");
                break;
            }
            is.skip(2);
            System.out.println("Character is " + (char) ch);
        }

    }
}
