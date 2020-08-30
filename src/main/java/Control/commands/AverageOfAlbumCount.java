package Control.commands;


import Control.Collection;
import Control.Command;

public class AverageOfAlbumCount implements Command {
    Collection collection;
    public AverageOfAlbumCount(Collection collection){
        this.collection=collection;
    }
    @Override
    public void execute(Object data) {
        collection.AverageOfAlbumCount();

    }
}
