package Control.commands;


import Control.Collection;
import Control.Command;


public class Head implements Command {
    Collection collection;
    public Head(Collection collection){
        this.collection=collection;
    }
    @Override
    public void execute(Object data) {
        collection.head();
    }
}
