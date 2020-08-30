import Control.*;
import Control.commands.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
     * Main class
     * @author Tsvetkov Fedor
     * @version 0
     * @since 0
     */
    public class Main {
        public static void main(String[] args) throws Exception{
            String path ="C:\\Users\\fedor\\Desktop\\Lab6\\lab5.0\\src\\main\\java\\Control\\MusicBands.csv";


            try {
                Reader reader =new Reader();
                FileManager fileManager = new FileManager();
                Collection collection = new Collection(fileManager.readFile(Reader.readFile(new Scanner(System.in, "UTF-8"),path)), reader);
                App app = new App(reader, collection, fileManager);
                Controller controller = new Controller(reader, new HelpCommand(app), new InfoCommand(collection), new ShowCommand(collection), new AddCommand(collection), new UpdateIdCommand(app), new RemoveByIdCommand(collection), new ClearCommand(collection), new SaveCommand(app), new ExecuteScriptCommand(app), new ExitCommand(app),new Head(collection),
                        new RemoveHead(collection),new FilterStartsWithNameCommand(collection),new FilterGreaterThanNumberOfParticipantsCommand(collection),new AddIfMaxCommand(collection),new AverageOfAlbumCount(collection));
                try {


                controller.start(System.in);} catch (NullPointerException e){
                    System.out.println("mistake");
                }
            }
            catch (NoSuchElementException e){
                System.out.println("Программа заверещена");
            }
        }
    }


