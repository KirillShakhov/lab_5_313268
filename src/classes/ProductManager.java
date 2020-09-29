package classes;

import com.google.gson.Gson;
import inputoutput.Readers.*;
import inputoutput.Readers.PrimitiveFloatReader;
import inputoutput.Readers.PrimitiveIntReader;
import inputoutput.Readers.RefLongReader;
import inputoutput.Readers.StringReader;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public final class ProductManager {
    private final PersonManager personManager = new PersonManager();
    //private static int currentId = 0;

    public String createProduct(){
        Integer id = IDGenerator.generateID();
        String name = StringReader.read("Введите название продукта: ", false);
        int x = PrimitiveIntReader.read("Введите Х: ", 0, "MIN");
        long y = RefLongReader.read("Введите Y: ", false);
        float price = PrimitiveFloatReader.read("Введите цену: ", 0, "MIN");
        String partNumber = StringReader.read("Введите номер партии продукта: ", false);
        UnitOfMeasure unitOfMeasure = createUnitOfMeasure();
        return new Gson().toJson(new Product(id, name, new Coordinates(x, y), price, partNumber, unitOfMeasure, personManager.createPerson()));
    }

    public String createProductWithParams(List<String> params){
        Integer id = IDGenerator.generateID();
        LocalDateTime creationDate = LocalDateTime.now();
        Coordinates coordinates = new Coordinates(Integer.parseInt(params.get(0)), Integer.parseInt(params.get(1)));
        String name = params.get(2);
        String partNumber = params.get(3);
        float price = Float.parseFloat(params.get(4));
        Person owner = new Person(params.get(5), params.get(6), Color.valueOf(params.get(7)) ,Country.valueOf(params.get(8)));
        UnitOfMeasure unitOfMeasure = UnitOfMeasure.valueOf(params.get(9));
        return new Gson().toJson(new Product(id, name, coordinates, price, partNumber, unitOfMeasure, owner));
    }

    public Float createPrice(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try{
                System.out.println("Введите цену: ");
                float price = scanner.nextFloat();
                return price;
            }
            catch (InputMismatchException ignored){
                System.out.println("\"Данные введены неверно. Попробуйте снова.\"");
            }
        }
    }

    public UnitOfMeasure createUnitOfMeasure(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите единицу измерения (1-килограммы, 2-литры, 3-миллилитры, 4-миллиграммы): ");
        while (true) {
            switch (scanner.nextLine()){
                case "1":
                    return UnitOfMeasure.KILOGRAMS;
                case "2":
                    return UnitOfMeasure.LITERS;
                case "3":
                    return UnitOfMeasure.MILLILITERS;
                case "4":
                    return UnitOfMeasure.MILLIGRAMS;
                default:
                    System.out.print("Необходимо выбрать из предложенных вариантов. Попробуйте снова: ");

            }
        }
    }
}
