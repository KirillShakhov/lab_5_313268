package commands.list;

import inputoutput.ResultShell;
import commands.Command;
import commands.CommandManager;
import commands.CommandType;
import exceptions.CommandExecutingException;

public class HelpCommand implements Command {
    private CommandManager commandManager;
    private String commandName;

    public HelpCommand(CommandManager commandManager){
        this.commandManager = commandManager;
        commandName = "help";

        commandManager.addNewCommand(commandName, this);
        commandManager.addNewSettings(CommandType.CLEAR, commandName);
    }

    @Override
    public void execute(String option, ResultShell resultShell) throws CommandExecutingException {
        if (!option.isEmpty()){
            resultShell.setCommandResult("Данная команда не содержит аргументов");
            return;
        }
        for (Command command: commandManager.getAllCommand()){
            if (!(command.getCommandDescription()==null)) {
                resultShell.setCommandResult(command.getCommandDescription() );
            }
        }
    }

    @Override
    public String getCommandDescription() {
        return "help: вывести справку по доступным командам";
    }
}
