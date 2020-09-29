package commands.list;

import inputoutput.ResultShell;
import commands.Command;
import commands.CommandManager;
import commands.CommandType;
import exceptions.CommandExecutingException;

public class ExitCommand implements Command {
    private CommandManager commandManager;
    private String commandName;

    public ExitCommand(CommandManager commandManager){
        commandName = "exit";

        commandManager.addNewCommand(commandName, this);
        commandManager.addNewSettings(CommandType.CLEAR, commandName);
    }

    public void execute(String option, ResultShell resultShell) throws CommandExecutingException {
        if (!option.isEmpty()) {
            resultShell.setCommandResult("Команда" + commandName + "не содержит аргументов. Выполнение прервано.");
            return;
        }
        System.out.println("Программа завершена");
        System.exit(1);
    }
    public String getCommandDescription() {
        return "exit: завершить программу (без сохранения в файл)";
    }
}
