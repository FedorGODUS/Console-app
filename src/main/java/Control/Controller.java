package Control;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Invoker
 * @author Gurin Minu
 * @version 0
 * @since 0
 */
public class Controller {
    private final HashMap<Pattern, Command> commandMap = new HashMap<>();
    Reader reader;
    ArrayList<CommandName> hist = new ArrayList();
    private Command help;
    private Command info;
    private Command show;
    private Command add;
    private Command update;
    private Command removeById;
    private Command clear;
    private Command save;
    private Command executeScript;
    private Command exit;
    private Command head;
    private Command removeHead;
    private Command filterGreaterThanNumberOfParticipants;
    private Command filterStartsWithName;
    private Command addIfMax;
    private Command averageOfAlbumCount;
    boolean flag=false;
    private String path;

    /**
     * Constructor Controller, который принимает команды
     */
    public Controller(Reader reader, Command help, Command info, Command show, Command add, Command updateId, Command removeById, Command clear, Command save, Command executeScript, Command exit,
                      Command head, Command removeHead, Command filterStartsWithName, Command filterGreaterThanNumberOfParticipants, Command addIfMax, Command averageOfAlbumCount) {
        this.reader = reader;
        this.help = help;
        this.info = info;
        this.show = show;
        this.add = add;
        this.update = updateId;
        this.removeById = removeById;
        this.clear = clear;
        this.save = save;
        this.executeScript = executeScript;
        this.exit = exit;
        this.addIfMax=addIfMax;
        this.averageOfAlbumCount=averageOfAlbumCount;
        this.filterGreaterThanNumberOfParticipants=filterGreaterThanNumberOfParticipants;
        this.head=head;
        this.removeHead=removeHead;
        this.filterStartsWithName=filterStartsWithName;
    }

    /**
     * Начинает принимать команды пользователя
     * @param inputStream Прием данных
     */
    public void start(InputStream inputStream) {
        boolean exitFlag = true;
        Scanner in = new Scanner(inputStream, "UTF-8");
        while (exitFlag && in.hasNextLine()) {
            CommandName command = reader.readCommand(in);
            switch (command) {
                case HELP:
                    help.execute("");
                    break;
                case INFO:
                    info.execute("");
                    break;
                case UPDATE:
                    update.execute(reader.readArgument());
                    break;
                case REMOVE_BY_ID:
                    removeById.execute(reader.readArgument());
                    break;
                case FILTER_GREATER_THEN_NUMBER_OF_PARTICIPANTS:
                    filterGreaterThanNumberOfParticipants.execute(reader.readArgument());
                    break;
                case ADD:
                    if (reader.getFileName().equals(" ")){
                    add.execute(reader.createBand(in));}
                    else {
                        try{
                            Collection.Bands.addAll(new FileManager().readFile(Reader.readFile(new Scanner(System.in,"UTF-8"),reader.getFileName())));
                    }catch (NullPointerException e){
                            System.out.println("Неправильный ввод");}
                    }
                    break;
                case HEAD:
                    head.execute("");
                    break;
                case REMOVE_HEAD:
                    removeHead.execute("");
                    break;
                case EXECUTE_SCRIPT:
                    try {
                        if (Reader.files.contains(reader.readScriptName())) {
                            flag=true;
                        }else {
                            flag=false;
                        }
                        if(flag){
                        System.out.println("mistake");
                        Reader.files.add(reader.readScriptName());
                        break;
                    }else{
                        InputStream fileInputStream = new FileInputStream(reader.readScriptName());
                        Reader.files.add(reader.readScriptName());
                        this.start(fileInputStream);
                        fileInputStream.close();
                        Reader.files.clear();
                    }

                    } catch (NoSuchElementException ex) {
                        System.out.println("Конец скрипта");
                    } catch (FileNotFoundException ex) {
                        System.out.println(" File is not found");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case SHOW:
                    show.execute("");
                    break;
                case CLEAR:
                    clear.execute("");
                    break;
                case SAVE:
                    save.execute("");
                    break;
                case EXIT:
                    exit.execute("");
                    exitFlag = false;
                    break;
                case AVERAGE_OF_ALBUMS_COUNT:
                    averageOfAlbumCount.execute("");
                    break;
                case FILTER_STARTS_WITH_NAME:
                    filterStartsWithName.execute(reader.readName());
                    break;
                case ADD_IF_MAX:
                    addIfMax.execute(reader.createBand(in));
                    break;
                case ERROR:
                    System.out.println("Неправильный ввод");
                    break;

            }
        }
    }
}
