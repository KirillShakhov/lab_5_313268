package commands.list;

import inputoutput.ResultShell;
import commands.Command;
import commands.CommandManager;
import commands.CommandType;
import exceptions.CommandExecutingException;
import inputoutput.InputOutput;

public class SaveCommand implements Command {
    private CommandManager commandManager;
    private InputOutput fileManager;
    private String commandName;

    public SaveCommand(CommandManager commandManager, InputOutput fileManager){
        this.commandManager = commandManager;
        this.fileManager = fileManager;
        commandName = "save";

        commandManager.addNewCommand(commandName, this);
        commandManager.addNewSettings(CommandType.CLEAR, commandName);
    }

    @Override
    public void execute(String option, ResultShell resultShell) throws CommandExecutingException {
        fileManager.write(resultShell);
    }

    @Override
    public String getCommandDescription() {
        return "save: сохранить коллекцию в файл";
    }
}
