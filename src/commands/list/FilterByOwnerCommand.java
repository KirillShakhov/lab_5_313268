package commands.list;

import inputoutput.CollectionShell;
import classes.Product;
import inputoutput.ResultShell;
import commands.Command;
import commands.CommandManager;
import commands.CommandType;
import exceptions.CommandExecutingException;

public class FilterByOwnerCommand implements Command {
    private CommandManager commandManager;
    private CollectionShell collectionShell;
    private String commandName;

    public FilterByOwnerCommand(CommandManager commandManager, CollectionShell collectionShell){
        this.commandManager = commandManager;
        this.collectionShell = collectionShell;
        commandName = "filter_by_owner";

        commandManager.addNewCommand(commandName, this);
        commandManager.addNewSettings(CommandType.ARG, commandName);
    }

    @Override
    public void execute(String option, ResultShell resultShell) throws CommandExecutingException {
        if (option.isEmpty()){
            resultShell.setCommandResult("Данная команда должна содержать аргументы");
            return;
        }
        boolean isNull = true;
        for (Product product : collectionShell.getProductList()){
            if (product.getOwner().getName().equals(option)){
                resultShell.setCommandResult(product.toString());
                isNull = false;
            }
        }
        if (isNull){
            resultShell.setCommandResult("Не найдены продукты с таким владельцем");
        }
    }

    @Override
    public String getCommandDescription() {
        return "filter_by_owner: вывести элементы, значение поля owner которых равно заданному";
    }
}
