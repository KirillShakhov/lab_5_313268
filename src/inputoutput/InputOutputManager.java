package inputoutput;

import classes.Product;
import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class InputOutputManager implements InputOutput{
    private CollectionShell collectionShell;
    private Gson json;
    private File file;

    public InputOutputManager(CollectionShell collectionShell, String filePath){
        this.collectionShell = collectionShell;
        file = new File(filePath);
    }

    public void write(ResultShell resultShell){
        json = new Gson();
        if (collectionShell.isEmpty()){
            resultShell.setCommandResult("Коллекция пуста, запись не была произведена");
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < collectionShell.getProductList().size(); i++ ){
                System.out.println(collectionShell.getProductList().get(i));
                bufferedWriter.write(json.toJson(collectionShell.getProductList().get(i))+ "\n");
            }
            bufferedWriter.flush();
        }catch (IOException exception){
            resultShell.setCommandResult("Ошибка записи в файл. Файл отсутствует или указан неверный путь.");
            return;
        }
        resultShell.setCommandResult("Запись прошла успешно");
    }

    public void read(ResultShell resultShell){
        json = new Gson();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                collectionShell.addNewProduct(json.fromJson(scanner.nextLine(), Product.class));
            }
            resultShell.setCommandResult("Данные успешно загружены");
            scanner.close();
        }
        catch (IOException exception){
            resultShell.setCommandResult("Чтение из файла было прервано");
        }
    }
}
