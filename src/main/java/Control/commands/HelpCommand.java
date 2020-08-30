package Control.commands;

import Control.App;
import Control.Command;

public class HelpCommand implements Command {
    App app;
    public HelpCommand(App app){
        this.app = app;
    }

    @Override
    public void execute(Object object) {
        app.help();
    }
}
