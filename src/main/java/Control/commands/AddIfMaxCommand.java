package Control.commands;


import Control.Collection;
import Control.Command;
import PartOf.Band;


public class AddIfMaxCommand implements Command<Band> {
    Collection collection;
    public AddIfMaxCommand(Collection collection){
        this.collection=collection;
    }

    @Override
    public void execute(Band band) {
        collection.addIfMax(band);
    }
}
