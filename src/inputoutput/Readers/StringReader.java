package inputoutput.Readers;

import java.util.Scanner;

/**
 * Считыватель строк.
 */
public class StringReader {
    public static String read(String messageForConsole, boolean canBeNull) {
        Scanner in = new Scanner(System.in);
        System.out.print(messageForConsole);
        if (in.hasNextLine()) {
            String readString = in.nextLine().trim();

            while (!canBeNull && readString.equals("")) {
                System.out.print("Данное поле не может быть пустым. " + messageForConsole);
                readString = in.nextLine().trim();
            }

            if (canBeNull && readString.equals("")) {
                readString = null;
            }
            return readString;
        }
        else{
            System.out.println("Завершение программы");
            System.exit(0);
            return "";
        }
    }
}
