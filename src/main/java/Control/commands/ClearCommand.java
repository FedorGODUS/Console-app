package Control.commands;

import Control.Collection;
import Control.Command;

public class ClearCommand implements Command {
    Collection collection;
    public ClearCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public void execute(Object object) {
        collection.clear();
    }
}
