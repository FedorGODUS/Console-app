package Control;



import PartOf.Band;

import java.util.Scanner;

/**
 * Receiver
 * Хранит исполнения команд
 */
public class App {
    private Reader reader;
    private Collection collection;
    private FileManager fileManager;

    /**
     * Constructor App
     * @param collection Класс, управляющий коллекцией
     */
    public App(Reader reader, Collection collection, FileManager fileManager) {
        this.reader = reader;
        this.fileManager = fileManager;
        this.collection = collection;
    }

    /**
     * Выводит справку по доступным командам
     */
    public void help() {
        System.out.println("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "head : вывести первый элемент коллекции\n" +
                "remove_head : вывести первый элемент коллекции и удалить его\n" +
                "filter_greater_than_number_of_participants numberOfParticipants : вывести элементы, значение поля numberOfParticipants которых больше заданного" +
                "\n" +
                "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                "filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки\n" +
                "print_descending : вывести элементы коллекции в порядке убывания");
    }

    public void saveFile(){
        fileManager.saveFile(collection);
    }

    /**
     * Обновляет значение элемента коллекции, id которого равен заданному
     * @param ip id элемента
     */
    public void updateId(Integer ip) {
        boolean flag = true;
        for (Band band : collection.getBands()) {
            if (band.getId() == ip) {
                collection.update(ip, reader.createBand(new Scanner(System.in, "UTF-8")));
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Неправильно введен ip, повторите команду:");
        }
        System.out.println("Объект обновлен");
    }

    /**
     * Считывает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
     */
    public void executeScript() {}


    /**
     * Завершает программу (без сохранения в файл)
     */
    public void exit() {
    }
}
