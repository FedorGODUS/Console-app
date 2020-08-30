package Control.commands;


import Control.Collection;
import Control.Command;


public class FilterStartsWithNameCommand implements Command<String> {
    Collection collection;
    public FilterStartsWithNameCommand(Collection collection){
        this.collection=collection;
    }
    @Override
    public void execute(String name) {
        collection.filterStartsWithName(name);


    }
}
