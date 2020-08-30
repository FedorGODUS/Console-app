package Control;

import PartOf.Band;
import PartOf.Coordinates;
import PartOf.Label;
import PartOf.MusicGender;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Gurin Minu
 * @version 0
 */
public class Reader {
    private File scriptName;
    private Integer argument;
    private String name;
    private  String FileName;
   public static ArrayList<File> files = new ArrayList<>();

    /**
     * Обрабатывает данные введенные пользователкм и возвращает команду
     *
     * @param in Scanner
     * @return CommandName
     */
    public CommandName readCommand(Scanner in) {
        String command = in.nextLine();
        String[] mas = command.split("\\s");
        boolean flag = true;
        CommandName commandName = null;

        if (command.equals("")) {
            return CommandName.ERROR;
        }
        for (CommandName cn : CommandName.values()) {
            if (cn.getCommand().equals(mas[0].toLowerCase())) {
                commandName = cn;
                flag = false;
                break;
            }
        }
        if (flag) {
            return CommandName.ERROR;
        }
        if (mas.length == 1 && (commandName == CommandName.CLEAR || commandName == CommandName.EXIT ||commandName == CommandName.AVERAGE_OF_ALBUMS_COUNT||commandName==CommandName.REMOVE_HEAD|| commandName == CommandName.HEAD|| commandName == CommandName.HELP || commandName == CommandName.INFO ||commandName==CommandName.ADD_IF_MAX|| commandName == CommandName.SAVE || commandName == CommandName.SHOW)) {
            return commandName;
        } else if (mas.length == 2) {
            if (commandName == CommandName.FILTER_GREATER_THEN_NUMBER_OF_PARTICIPANTS || commandName == CommandName.REMOVE_BY_ID || commandName == CommandName.UPDATE) {
                try {
                    argument = Integer.parseInt(mas[1]);
                    return commandName;
                } catch (NumberFormatException e) {
                    return CommandName.ERROR;
                }
            } else if (commandName == CommandName.EXECUTE_SCRIPT) {
                scriptName = new File(mas[1]);
                System.out.println(files.size());
                return commandName;
            } else if (commandName == CommandName.FILTER_STARTS_WITH_NAME) {
                try {
                    name = mas[1];
                    return commandName;
                } catch (NumberFormatException e) {
                    return CommandName.ERROR;
                }
            }
            else if (commandName==CommandName.ADD){
                try {
                    FileName =mas[1];
                    return commandName;
                } catch (NumberFormatException e) {
                    return CommandName.ERROR;
                }

            }
                else {
                return CommandName.ERROR;
            }
        } else {
            return CommandName.ERROR;
        }
    }

    /**
     * Возвращает введенные пользователем численные аргументы
     *
     * @return int
     */
    public int readArgument() {
        return argument;
    }
    /**
     * Возвращает введенные пользователем String аргументы
     *
     * @return String
     */
    public String getFileName() {
        return FileName;
    }

    /**
     * Возвращает введенные пользователем String аргументы
     *
     * @return String
     */
    public String  readName() {
        return name;
    }

    /**
     * Возвращает файл скрипта, путь к которому ввел пользователь
     *
     * @return File
     */
    public File readScriptName() {
        return scriptName;
    }

    /**
     * Возвращает изначачальный файл, путь к которому указал пользователь
     *
     * @param in Scanner
     * @return File
     */

    public static File readFile(Scanner in,String p) {
        String path =p;
        Scanner file;
        boolean flag = true;
        File startFile = new File(path);
        while (flag) {
            try {
                if (Files.isHidden(startFile.toPath())) {
                    System.out.println("Файл спрятался, укажите другой или найдите его");
                    path = in.nextLine();
                    startFile = new File(path);
                    continue;
                } else if (!Files.isReadable(startFile.toPath())) {
                    System.out.println("Файл нельзя прочитать, укажите другой или измените разрешение");
                    path = in.nextLine();
                    startFile = new File(path);
                    continue;
                } else if (!Files.isWritable(startFile.toPath())) {
                    System.out.println("Файл нельзя изменить, укажите другой или измените разрешение");
                    path = in.nextLine();
                    startFile = new File(path);
                    continue;
                } else if (!Files.isExecutable(startFile.toPath())) {
                    System.out.println("Файл нельзя execute, укажите другой или измените разрешение");
                    path = in.nextLine();
                    startFile = new File(path);
                    continue;
                }
                file = new Scanner(startFile, "UTF-8");
                flag = false;
            } catch (NoSuchElementException | IOException e) {
                System.out.println("Неправильно введен путь повторите попытку: ");
                path = in.nextLine();
                startFile = new File(path);
            }
        }
        return startFile;
    }

    /**
     * Возвращает строку, введенную пользователем
     *
     * @param scanner Ввод пользователя
     * @return Ненулевая строка
     */
    String readString(Scanner scanner) {
        String string = scanner.nextLine();
        while (string.equals("")||string.equals(" ")||string.equals("  ")||string.equals("   ")) {
            System.out.println("Некорректный ввод, попробуйте еще раз: ");
            string = scanner.nextLine();
        }
        return string;
    }


    /**
     * Возвращает long, введенный пользователем
     *
     * @param scanner Ввод пользователя
     * @return long
     */

    long readLong(Scanner scanner){
        long x = 0;
        boolean flag = true;
        String s = scanner.nextLine();
        while (s.equals("") || flag || x == Long.MAX_VALUE || x ==Long.MIN_VALUE){
            flag = true;
            try {
                x=Long.parseLong(s);
                flag = false;
            }catch (NumberFormatException e){
                System.out.println("Некорректный ввод, попробуйте еще раз: ");
                s=scanner.nextLine();
            }
        }
        return x;
    }
    /**
     * Возвращает Double, введенный пользователем
     *
     * @param scanner Ввод пользователя
     * @return double
     */

    double readDouble(Scanner scanner){
        double x = 0;
        boolean flag = true;
        String s = scanner.nextLine();
        while (s.equals("") || flag || x==Double.POSITIVE_INFINITY || x==Double.NEGATIVE_INFINITY){
            flag = true;
            try{
                x=Double.parseDouble(s);
                flag = false;}catch (NumberFormatException e){
                System.out.println("Некорректный ввод, попробуйте еще раз: ");
                s=scanner.nextLine();
            }
        }
        return x;
    }

    /**
     * Возвращает int, введенный пользователем
     *
     * @param scanner Ввод пользователя
     * @return int
     */

    int readInt(Scanner scanner){
        int x = 0;
        boolean flag = true;
        String s = scanner.nextLine();
        while (s.equals("") || flag){
            flag = true;
            try {
                x=Integer.parseInt(s);
                flag = false;
            }catch (NumberFormatException e){
                System.out.println("Некорректный ввод, попробуйте еще раз: ");
                s=scanner.nextLine();
            }
        }
        return x;
    }

    /**
     * Возвращает GENDER, введенный пользователем
     *
     * @param scanner Ввод пользователя
     * @return gender
     */
    MusicGender readMusicGender(Scanner scanner){
        MusicGender x = null;
        boolean flag = true;
        String s = scanner.nextLine();
        if (s.equals("")){
            x = null;
        }else {
            while (flag){
                try {
                    x=MusicGender.valueOf(s);
                    flag=false;
                }catch (IllegalArgumentException f){
                    System.out.println("Жанр введен неверно, повторите попытку");
                    s = scanner.nextLine();
                    if (s.equals("")) {
                        x = null;
                        break;
                    }

                }
            }
        }
        return x;
    }


    /**
     * Возвращает Band, введенный пользователем
     *
     * @param scanner Ввод пользователя
     * @return band
     */

    public Band createBand(Scanner scanner){
        //name
        System.out.println("name");
        String name = this.readString(scanner);
        //X
        System.out.println("X");
        Long X = this.readLong(scanner);
        //Y
        System.out.println("Y");
        Long Y= this.readLong(scanner);
        //numberOfParticipants
        System.out.println("numberOfParticipants");
        Integer numberOfParticipants = this.readInt(scanner);
        while (numberOfParticipants<0){
            System.out.println("again pl");
            numberOfParticipants= readInt(scanner);
        }
        //albumsCount
        System.out.println("albumsCount");
        Integer albumsCount = this.readInt(scanner);
        while (albumsCount<0){
            System.out.println("again pl");
            albumsCount= readInt(scanner);
        }
        //description
        System.out.println("description");
        String description = this.readString(scanner);
        //gender
        System.out.println("gender");
        System.out.println("Choose one of them: ROCK," +"SOUL," + "BLUES," + "PUNK_ROCK");
        MusicGender gender = this.readMusicGender(scanner);
        //sales
        System.out.println("sales");
        Double sales = this.readDouble(scanner);


        return new Band(name,new Coordinates(X,Y),numberOfParticipants,albumsCount,description, LocalDateTime.now(),gender,new Label(sales));
    }
}
