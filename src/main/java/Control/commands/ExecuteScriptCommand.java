package Control.commands;

import Control.App;
import Control.Command;

public class ExecuteScriptCommand implements Command {
    App app;
    public ExecuteScriptCommand(App app){
        this.app = app;
    }

    @Override
    public void execute(Object object) {

    }
}
