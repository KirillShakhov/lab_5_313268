package commands.list;

import inputoutput.CollectionShell;
import inputoutput.ResultShell;
import commands.Command;
import commands.CommandManager;
import commands.CommandType;
import exceptions.CommandExecutingException;

public class RemoveGreaterKeyCommand implements Command {
    private CommandManager commandManager;
    private CollectionShell collectionShell;
    private String commandName;

    public RemoveGreaterKeyCommand(CommandManager commandManager, CollectionShell collectionShell){
        this.commandManager = commandManager;
        this.collectionShell = collectionShell;
        commandName = "remove_greater_key";

        commandManager.addNewCommand(commandName, this);
        commandManager.addNewSettings(CommandType.CLEAR, commandName);
    }

    @Override
    public void execute(String option, ResultShell resultShell) throws CommandExecutingException {
        if (option.isEmpty()){
            resultShell.setCommandResult("Команда remove_greater_key должка содержать аргумент");
            return;
        }
        try {
            collectionShell.getProductList().removeIf(x -> x.getId().equals(Integer.parseInt(option)));
            resultShell.setCommandResult("Объекты удалены");
        } catch (Exception exception){
            resultShell.setCommandResult("Аргумент невалиден");
        }
    }

    @Override
    public String getCommandDescription() {
        return "remove_greater_key: удалить из коллекции все элементы, ключ которых превышает заданный";
    }
}
