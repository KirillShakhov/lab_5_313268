package commands.list;

import inputoutput.CollectionShell;
import inputoutput.ResultShell;
import commands.Command;
import commands.CommandManager;
import commands.CommandType;
import exceptions.CommandExecutingException;

public class InfoCommand implements Command {
    private CommandManager commandManager;
    private CollectionShell collectionShell;

    public InfoCommand(CommandManager commandManager, CollectionShell collectionShell){
        this.commandManager = commandManager;
        this.collectionShell = collectionShell;

        commandManager.addNewCommand("info", this);
        commandManager.addNewSettings(CommandType.CLEAR, "info");
    }


    @Override
    public void execute(String option, ResultShell resultShell) throws CommandExecutingException {
        if (!option.isEmpty()){
            resultShell.setCommandResult("Команда info не содержит аргументов");
            return;
        }
        resultShell.setCommandResult(collectionShell.getInfo());
    }

    @Override
    public String getCommandDescription() {
        return "info: вывести в стандартный поток вывода информацию о коллекции";
    }
}
