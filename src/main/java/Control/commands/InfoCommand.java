package Control.commands;

import Control.Collection;
import Control.Command;

public class InfoCommand implements Command {
    Collection collection;
    public InfoCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public void execute(Object object) {
        collection.info();
    }
}
