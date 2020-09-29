package classes;

import inputoutput.Readers.StringReader;

import java.util.Scanner;

public class PersonManager {
    public Person createPerson(){
        System.out.println("Введите информацию о владельце продукта");
        String name = StringReader.read("Введите имя владельца: ", false);
        String passportID = StringReader.read("Введите пасспортные данные: ", true);
        Color eyeColor = createEyeColor();
        Country nationality = createNationality();
        return new Person(name, passportID, eyeColor, nationality);
    }

    public Color createEyeColor(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите цвет глаз (1-красные, 2-голубые, 3-оранжевые, 4-коричневые): ");
        while (true) {
            switch (scanner.nextLine()){
                case "1":
                    return Color.RED;
                case "2":
                    return Color.BLUE;
                case "3":
                    return Color.ORANGE;
                case "4":
                    return Color.BROWN;
                default:
                    System.out.print("Необходимо выбрать из предложенных вариантов. Попробуйте снова: ");

            }
        }
    }

    public Country createNationality(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите гражданство (1-российское, 2-французское, 3-индийское, 4-итальянское, 5-северокорейское): ");
        while (true) {
            switch (scanner.nextLine()){
                case "1":
                    return Country.RUSSIA;
                case "2":
                    return Country.FRANCE;
                case "3":
                    return Country.INDIA;
                case "4":
                    return Country.ITALY;
                case "5":
                    return Country.NORTH_KOREA;
                default:
                    System.out.print("Необходимо выбрать из предложенных вариантов. Попробуйте снова: ");

            }
        }
    }
}
