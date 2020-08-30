package Control.commands;

import Control.Collection;
import Control.Command;

public class ShowCommand implements Command {
    Collection collection;
    public ShowCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public void execute(Object object) {
        collection.show();
    }
}
