package Control.commands;

import Control.Collection;
import Control.Command;

public class RemoveByIdCommand implements Command<Integer> {
    Collection collection;
    public RemoveByIdCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public void execute(Integer id) {
        collection.removeById(id);
    }
}
