package commands;

import inputoutput.ResultShell;
import exceptions.CommandExecutingException;
import inputoutput.InputOutput;

public class LoadCommand implements Command {
    private CommandManager commandManager;
    private InputOutput fileManager;
    private String currentName;

    public LoadCommand(CommandManager commandManager, InputOutput fileManager){
        this.commandManager = commandManager;
        this.fileManager = fileManager;
        currentName = "load";

        commandManager.addNewCommand(currentName, this);
        commandManager.addNewSettings(CommandType.CLEAR, currentName);
    }

    @Override
    public void execute(String option, ResultShell resultShell) throws CommandExecutingException {
        fileManager.read(resultShell);
    }

    @Override
    public String getCommandDescription() {
        return null;
    }
}
