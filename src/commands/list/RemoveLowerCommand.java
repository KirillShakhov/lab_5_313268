package commands.list;

import inputoutput.CollectionShell;
import classes.Product;
import inputoutput.ResultShell;
import com.google.gson.Gson;
import commands.Command;
import commands.CommandManager;
import commands.CommandType;
import exceptions.CommandExecutingException;

public class RemoveLowerCommand implements Command {
    private CommandManager commandManager;
    private CollectionShell collectionShell;
    private String commandName;

    public RemoveLowerCommand(CommandManager commandManager, CollectionShell collectionShell){
        this.commandManager = commandManager;
        this.collectionShell = collectionShell;
        commandName = "remove_lower";

        commandManager.addNewCommand(commandName, this);
        commandManager.addNewSettings(CommandType.OBJECT, commandName);
    }

    @Override
    public void execute(String option, ResultShell resultShell) throws CommandExecutingException {
        if (option.isEmpty()){
            resultShell.setCommandResult("Команда remove_lower должна иметь аргумент");
            return;
        }
        Product optionProduct = new Gson().fromJson(option, Product.class);
        for (Product product: collectionShell.getProductList()){
            if (product.getPrice() < optionProduct.getPrice()){
                collectionShell.removeProductById(product.getId());
            }
        }
    }

    @Override
    public String getCommandDescription() {
        return "remove_lower: удалить из коллекции все элементы, меньшие чем заданный";
    }
}
