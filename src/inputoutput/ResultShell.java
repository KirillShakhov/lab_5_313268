package inputoutput;

public class ResultShell {
    private String commandResult = "";

    public ResultShell(String commandResult){
        //this.commandResult = commandResult;
        System.out.println(commandResult);
    }

    public ResultShell(){

    }

    public String getCommandResult(){
        return "";
    }

    public void setCommandResult(String commandResult){

        //this.commandResult += commandResult + "\n";
        System.out.println(commandResult);
    }
}
