package commands.list;

import inputoutput.CollectionShell;
import classes.Product;
import inputoutput.ResultShell;
import commands.Command;
import commands.CommandManager;
import commands.CommandType;
import exceptions.CommandExecutingException;

public class ShowCommand implements Command {
    private CommandManager commandManager;
    private CollectionShell collectionShell;
    private String commandName;

    public ShowCommand(CommandManager commandManager, CollectionShell collectionShell){
        this.commandManager = commandManager;
        this.collectionShell = collectionShell;
        commandName = "show";

        commandManager.addNewCommand(commandName, this);
        commandManager.addNewSettings(CommandType.CLEAR, commandName);
    }

    @Override
    public void execute(String option, ResultShell resultShell) throws CommandExecutingException {
        if (!option.isEmpty()){
            resultShell.setCommandResult("Данная команда не содержит аргументов");
            return;
        }
        for (Product product: collectionShell.getProductList()){
            resultShell.setCommandResult(product.toString());
        }
    }

    @Override
    public String getCommandDescription() {
        return "show: вывести в стандартный поток вывода все элементы коллекциии в строковом представлении";
    }
}
