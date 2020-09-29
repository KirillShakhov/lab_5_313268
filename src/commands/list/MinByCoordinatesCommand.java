package commands.list;

import inputoutput.CollectionShell;
import inputoutput.ResultShell;
import commands.Command;
import commands.CommandManager;
import commands.CommandType;
import exceptions.CommandExecutingException;

import java.util.Comparator;

public class MinByCoordinatesCommand implements Command {
    private CommandManager commandManager;
    private CollectionShell collectionShell;
    private String commandName;

    public MinByCoordinatesCommand(CommandManager commandManager, CollectionShell collectionShell){
        this.commandManager = commandManager;
        this.collectionShell = collectionShell;
        commandName = "min_by_coordinates";

        commandManager.addNewCommand(commandName, this);
        commandManager.addNewSettings(CommandType.CLEAR, commandName);
    }

    @Override
    public void execute(String option, ResultShell resultShell) throws CommandExecutingException {
        if (!option.isEmpty()){
            resultShell.setCommandResult("Данная команда не должна содержать аргументов");
            return;
        }
        if (collectionShell.isEmpty()){
            resultShell.setCommandResult("Коллекция пуста");
            return;
        }
        resultShell.setCommandResult(collectionShell.getProductList().stream().
                min(Comparator.comparingInt(x -> x.getCoordinates().getX())).get().toString());
    }

    @Override
    public String getCommandDescription() {
        return "min_by_coordinates: вывести любой объект из коллекции, значение поля coordinates которого является минимальным";
    }
}
