package commands.list;

import inputoutput.CollectionShell;
import inputoutput.ResultShell;
import commands.Command;
import commands.CommandManager;
import commands.CommandType;
import exceptions.CommandExecutingException;

public class ClearCommand implements Command {
    private final CollectionShell collectionShell;
    private CommandManager commandManager;
    private String commandName;

    public ClearCommand(CollectionShell collectionShell, CommandManager commandManager){
        this.collectionShell = collectionShell;
        this.commandManager = commandManager;
        commandName = "clear";

        commandManager.addNewCommand(commandName, this);
        commandManager.addNewSettings(CommandType.CLEAR, commandName);
    }

    public void execute(String option, ResultShell resultShell) throws CommandExecutingException {
        if (!option.isEmpty()){
            resultShell.setCommandResult("Команда" + commandName+ "не содержит аргументов. Выполнение прервано.");
            return;
        }
        collectionShell.clearAll();
        resultShell.setCommandResult("Коллекция очищена");
    }
    public String getCommandDescription() {
        return "clear: очистить коллекцию";
    }
}
