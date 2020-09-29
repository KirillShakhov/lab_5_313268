package commands.list;

import inputoutput.CollectionShell;
import classes.Product;
import inputoutput.ResultShell;
import commands.Command;
import commands.CommandManager;
import commands.CommandType;
import exceptions.CommandExecutingException;

public class FilterLessThanPartNumberCommand implements Command {
    private CommandManager commandManager;
    private CollectionShell collectionShell;

    public FilterLessThanPartNumberCommand(CommandManager commandManager, CollectionShell collectionShell){
        this.commandManager = commandManager;
        this.collectionShell = collectionShell;

        commandManager.addNewCommand("filter_less_than_part_number", this);
        commandManager.addNewSettings(CommandType.ARG, "filter_less_than_part_number");
    }

    @Override
    public void execute(String option, ResultShell resultShell) throws CommandExecutingException {
        if (option.isEmpty()){
            resultShell.setCommandResult("Данная команда должна содержать аргумент");
            return;
        }
        Integer partNumber;
        try{
            partNumber = Integer.parseInt(option);
        } catch (Exception exception){
            resultShell.setCommandResult("Аргумент должен быть числом");
            throw new CommandExecutingException();
        }
        boolean isNull = true;
        for (Product product: collectionShell.getProductList()){
            Integer currentProductPartNumber = Integer.parseInt(product.getPartNumber());
            if (currentProductPartNumber < partNumber){
                resultShell.setCommandResult(product.toString());
                isNull = false;
            }
        }
        if (isNull) {
            resultShell.setCommandResult("Не найдены продукты с номером партии меньшим заданного");
        }
    }

    @Override
    public String getCommandDescription() {
        return "filter_less_than_part_number: вывести элементы, значение поля partNumber которых меньше заданного";
    }
}
