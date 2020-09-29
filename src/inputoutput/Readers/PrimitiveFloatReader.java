package inputoutput.Readers;

import java.util.Scanner;

/**
 * Считыватель примитивного float.
 */

public class PrimitiveFloatReader {
    public static float read(String messageForConsole, int limit, String type) {
        System.out.print(messageForConsole);
        Scanner sc = new Scanner(System.in);
        float result = 0;
        boolean end = false;
        while (!end && sc.hasNextLine()) {
            try {
                result = Float.parseFloat(sc.nextLine().trim());
                switch (type) {
                    case ("MIN"):
                        if (result > limit) { end = true; }
                        else { System.out.print("Вы ввели не подходящее значение. " + "Оно должно быть больше " + limit + ". Попробуйте снова: ");}
                        break;
                    case ("MAX"):
                        if (result < limit) { end = true; }
                        else { System.out.print("Вы ввели не подходящее значение. " + "Оно должно быть меньше " + limit + ". Попробуйте снова: ");}
                        break;
                }
            } catch (NumberFormatException ex) {
                System.out.print("Вы должны ввести число, попробуйте снова: ");
            }
        }
        return result;
    }
}
