package commands.list;

import classes.ProductManager;
import inputoutput.ResultShell;
import commands.Command;
import commands.CommandManager;
import commands.CommandType;
import exceptions.CommandExecutingException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command {
    private CommandManager commandManager;
    private String commandName;
    private ProductManager productManager = new ProductManager();

    public ExecuteScriptCommand(CommandManager commandManager){
        this.commandManager = commandManager;
        commandName = "execute_script";

        commandManager.addNewCommand(commandName, this);
        commandManager.addNewSettings(CommandType.SCRIPT, commandName);
    }

    @Override
    public void execute(String option, ResultShell resultShell) throws CommandExecutingException{
        File scriptFile = new File(option);
        Scanner scanner;
        try {
            scanner = new Scanner(scriptFile);
        } catch (FileNotFoundException exception){
            resultShell.setCommandResult("Файл не найден");
            return;
        }
        while (scanner.hasNextLine()){
            String currentCommand = scanner.nextLine();
            List<String> commandInfo = Arrays.asList(currentCommand.split(" "));
            CommandType currentCommandType = commandManager.getTypeByName(commandInfo.get(0));
            System.out.println(currentCommand + " " + currentCommandType);
            switch (currentCommandType){
                case CLEAR:
                    commandManager.executeCommand(commandInfo.get(0), "", resultShell);
                    break;
                case ARG:
                    commandManager.executeCommand(commandInfo.get(0), commandInfo.get(1), resultShell);
                    break;
                case OBJECT:
                    List<String> argList = new ArrayList<>();
                    for (int i = 0; i < 10; i++){
                        argList.add(scanner.nextLine());
                    }
                    System.out.println(argList);
                    commandManager.executeCommand(commandInfo.get(0), productManager.createProductWithParams(argList), resultShell);
                    break;
            }
        }
    }

    @Override
    public String getCommandDescription() {
        return "execute_script: считать и исполнить скрипт из указанного файла";
    }
}
