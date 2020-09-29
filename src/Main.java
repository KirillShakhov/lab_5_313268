import commands.*;
import classes.*;
import commands.list.*;
import inputoutput.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static CommandManager commandManager;

    public static void main(String[] args){
        loadContext();
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        System.out.println("Чтобы посмотреть полный список доступных команд, вызовите команду help");
        System.out.print(">");
        while(scanner.hasNextLine()){
            System.out.print("> ");
            String commandInfo = scanner.nextLine();
            if (commandInfo.equals("")){
                continue;
            }
            List<String> commandInfoList = Arrays.asList(commandInfo.split(" "));
            ResultShell resultShell = new ResultShell();
            String commandName = commandInfoList.get(0);
            try{
                switch(commandManager.getTypeByName(commandName)){
                    case OBJECT:
                        String serialObject = productManager.createProduct();
                        commandManager.executeCommand(commandName, serialObject, resultShell);
                        break;
                    case CLEAR:
                        commandManager.executeCommand(commandName, "", resultShell);
                        break;
                    case ARG:
                    case SCRIPT:
                        commandManager.executeCommand(commandName, commandInfoList.get(1), resultShell);
                        break;
                }
                System.out.println(resultShell.getCommandResult());
            } catch (NullPointerException exception){
                System.out.println("Такой команды не существует");
            }
        }
        System.out.println("Завершение работы");
    }

    public static void loadContext(){
        commandManager = new CommandManager();
        CollectionShell collectionShell = new ProductCollectionManager();

        InputOutput fileManager = new InputOutputManager(collectionShell, "saveFile");

        Command clearCommand = new ClearCommand(collectionShell, commandManager);
        Command executeScriptCommand = new ExecuteScriptCommand(commandManager);
        Command exitCommand = new ExitCommand(commandManager);
        Command filterByOwnerCommand = new FilterByOwnerCommand(commandManager,collectionShell);
        Command filterLessThanPartNumberCommand = new FilterLessThanPartNumberCommand(commandManager, collectionShell);
        Command helpCommand = new HelpCommand(commandManager);
        Command infoCommand = new InfoCommand(commandManager, collectionShell);
        Command insertCommand = new InsertCommand(commandManager, collectionShell);
        Command minByCoordinatesCommand = new MinByCoordinatesCommand(commandManager, collectionShell);
        Command removeGreaterCommand = new RemoveGreaterCommand(commandManager,collectionShell);
        Command removeGreaterKeyCommand = new RemoveGreaterKeyCommand(commandManager, collectionShell);
        Command removeKeyCommand = new RemoveKeyCommand(commandManager, collectionShell);
        Command removeLowerCommand = new RemoveLowerCommand(commandManager, collectionShell);
        Command saveCommand = new SaveCommand(commandManager, fileManager);
        Command showCommand = new ShowCommand(commandManager, collectionShell);

        Command loadCommand = new LoadCommand(commandManager, fileManager);
        commandManager.executeCommand("load", "", new ResultShell());
    }
}
