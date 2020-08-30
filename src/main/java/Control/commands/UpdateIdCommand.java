package Control.commands;

import Control.App;
import Control.Command;


public class UpdateIdCommand implements Command<Integer> {
    App app;
    public UpdateIdCommand(App app){
        this.app = app;
    }

    @Override
    public void execute(Integer ip) {
        app.updateId(ip);
    }
}
