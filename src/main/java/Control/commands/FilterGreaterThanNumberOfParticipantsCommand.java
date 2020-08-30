package Control.commands;


import Control.Collection;
import Control.Command;


public class FilterGreaterThanNumberOfParticipantsCommand implements Command<Integer> {
    Collection collection;
    public FilterGreaterThanNumberOfParticipantsCommand(Collection collection){
        this.collection=collection;
    }
    @Override
    public void execute(Integer NoP) {
        collection.filterGreaterThanNumberOfParticipants(NoP);
    }
}
