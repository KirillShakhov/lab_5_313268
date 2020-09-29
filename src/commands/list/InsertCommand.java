package commands.list;

import inputoutput.CollectionShell;
import classes.Product;
import inputoutput.ResultShell;
import com.google.gson.Gson;
import commands.Command;
import commands.CommandManager;
import commands.CommandType;
import exceptions.CommandExecutingException;

public class InsertCommand implements Command {
    private CommandManager commandManager;
    private CollectionShell collectionShell;

    public InsertCommand(CommandManager commandManager, CollectionShell collectionShell){
        this.commandManager = commandManager;
        this.collectionShell = collectionShell;

        commandManager.addNewCommand("insert", this);
        commandManager.addNewSettings(CommandType.OBJECT, "insert");
    }

    @Override
    public void execute(String option, ResultShell resultShell) throws CommandExecutingException {
        if (option.isEmpty()){
            resultShell.setCommandResult("Команда insert должна содержать аргумент");
            return;
        }
        Product product = new Gson().fromJson(option, Product.class);
        System.out.println(product);
        collectionShell.addNewProduct(product);
        resultShell.setCommandResult("Объект успешно добавлен");
    }

    @Override
    public String getCommandDescription() {
        return "insert: добавить новый элемент в коллекцию";
    }
}
