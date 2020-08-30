package Control.commands;


import Control.Collection;
import Control.Command;
import PartOf.Band;


public class AddCommand implements Command<Band> {
    Collection collection;
    public AddCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public void execute(Band musicBand) {
        collection.add(musicBand);
    }
}
