package commands;

import inputoutput.ResultShell;
import exceptions.CommandExecutingException;

public interface Command {
    void execute (String option, ResultShell resultShell) throws CommandExecutingException;
    String getCommandDescription();
}
