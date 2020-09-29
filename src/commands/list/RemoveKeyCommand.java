package commands.list;

import inputoutput.CollectionShell;
import inputoutput.ResultShell;
import commands.Command;
import commands.CommandManager;
import commands.CommandType;
import exceptions.CommandExecutingException;

public class RemoveKeyCommand implements Command {
    private CommandManager commandManager;
    private CollectionShell collectionShell;
    private String commandName;

    public RemoveKeyCommand(CommandManager commandManager, CollectionShell collectionShell){
        this.commandManager = commandManager;
        this.collectionShell = collectionShell;
        commandName = "remove_key";

        commandManager.addNewCommand(commandName, this);
        commandManager.addNewSettings(CommandType.ARG, commandName);
    }

    @Override
    public void execute(String option, ResultShell resultShell) throws CommandExecutingException {
        if (option.isEmpty()){
            resultShell.setCommandResult("Команда remove_key должна содержать аргумент");
            return;
        }
        try{
            Integer removeId = Integer.parseInt(option);
            collectionShell.removeProductById(removeId);
            resultShell.setCommandResult("Продукт успешно удален. Id удаленного продукта: " + removeId);
        } catch (NullPointerException exception){
            resultShell.setCommandResult("Элемента с заданным id не существует");
        } catch (Exception exception){
            resultShell.setCommandResult("Аргумент команды невалиден");
            throw new CommandExecutingException();
        }
    }

    @Override
    public String getCommandDescription() {
        return "remove_key: удалить элемент из коллекции по его ключу";
    }
}
