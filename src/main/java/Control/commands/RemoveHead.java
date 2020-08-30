package Control.commands;


import Control.Collection;
import Control.Command;

public class RemoveHead implements Command {
    Collection collection;
    public RemoveHead(Collection collection){
        this.collection=collection;
    }
    @Override
    public void execute(Object data) {
        collection.removeHead();
    }
}
