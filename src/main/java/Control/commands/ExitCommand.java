package Control.commands;

import Control.App;
import Control.Command;


public class ExitCommand implements Command {
    App app;
    public ExitCommand(App app){
        this.app = app;
    }

    @Override
    public void execute(Object object) {
        app.exit();
    }
}
