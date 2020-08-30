package Control.commands;

import Control.App;
import Control.Command;

public class SaveCommand implements Command {
    App app;
    public SaveCommand(App app){
        this.app = app;
    }

    @Override
    public void execute(Object object) {
        app.saveFile();
    }
}
