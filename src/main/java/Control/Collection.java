package Control;


import PartOf.Band;

import java.util.Date;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Класс, управляющий коллекцией
 */
public class Collection {
    public static LinkedList<Band> Bands;
    Reader reader;

    private Date initDate = new Date();

    /**
     * Constructor collection
     * @param Bands Коллекция, которой управляет класс
     */
    public Collection(LinkedList<Band> Bands, Reader reader) {
        this.Bands = Bands;
        this.reader = reader;
    }

    /**
     * Добавляет новый элемент в коллекцию
     * @param band добавляемый элемент
     */
    public void add(Band band) {
        Bands.add(band);
        System.out.println("Объект добавлен в коллекцию");
    }

    /**
     * Обновляет значения элемента в коллекции
     * @param id id, обновляемого элемента
     * @param band Объект, который содержит значения, кторые должен принять обновляемый элемент
     */
    public void update(int id, Band band) {
        for(Band b: Bands){
            if (b.getId() == id) {
                b.setAlbumsCount(band.getAlbumsCount());
                b.setCoordinates(band.getCoordinates());
                b.setDate(band.getDate());
                b.setDescription(band.getDescription());
                b.setGenre(band.getGenre());
                b.setLabel(band.getLabel());
                b.setName(band.getName());
                b.setNumberOfParticipants(band.getNumberOfParticipants());
            }
        }
    }
    /**
     * выводит среднее значение поля albumsCount для всех элементов коллекции
     */
    public void AverageOfAlbumCount(){
        int sum=0;
        if (Bands.size()!=0) {
            for (Band band : Bands) {
                sum = sum+band.getAlbumsCount();
            }
            sum = (sum / Bands.size());
            System.out.println(sum);
        }
        else {
            System.out.println("0"); }
    }




    /**
     * Возвращает дату инициализации коллекции
     * @return Date
     */
    public Date getInitDate() {
        return initDate;
    }




    /**
     * Очищает коллекцию
     */
    public void clear() {
        Bands.clear();
        System.out.println("Коллекция очищена");
    }

    /**
     * Возвращает элементы, значение поля numberOfParticipants которых меньше заданного
     * @param nop numberOfParticipants
     */


    /**
     * Выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
     */
    public void info() {
        System.out.println("Тип: " + Bands.getClass() + "\nДата инициализации: " + getInitDate() + "\nКоличество элементов: " + Bands.size());
    }

    /**
     * Удаляет элемент из коллекции по его id
     * @param id id, удаляемого элемента
     */
    public void removeById(Integer id) {
        Band band = null;
        boolean flag = true;
        for (Band b : Bands) {
            if (b.getId() == id) {
                band = b;
                flag = false;
            }
        }
        if (!flag){
            Bands.remove(band);
        }
        if (flag) {
            System.out.println("id не найден, повторите команду");
        }
    }

    /**
     *выводит первый элемент коллекции
     */
    public void head(){
        if (Bands.size()!=0){
            System.out.println(Bands.getFirst());
        }else {
            System.out.println("The collection is empty.");
        }

    }
    /**
     *выводит все элементы коллекции
     */
    public void show(){
        if (!Bands.isEmpty()){
            for (Band band:Bands){
                System.out.println(band.toString());
            }
        }else {
            System.out.println("The collection is empty.");
        }
    }

    /**
     *выводит первый элемент коллекции и удаляет его
     */
    public void removeHead(){
        if (Bands.size()>0){
            System.out.println(Bands.getFirst());
            Bands.removeFirst();}
        else{
            System.out.println("The collection is empty.");
        }

    }

    /**
     * фильтрует элементы коллекции относительно(больше введённого) Number Of Participants
     * @param NoP Number Of Participants, фильтруемого элемента
     */
    public void filterGreaterThanNumberOfParticipants(int NoP){
        for (Band band:Bands) {
            if (band.getNumberOfParticipants()>NoP){
                System.out.println(band.toString());
            }
        }
    }

    /**
     * добавляют элемент в коллекцию если он больше максимального элемента в коллекции
     * @param band Band, добовляемого элементо
     */
    public void addIfMax(Band band){

        if(!Bands.isEmpty()){

            int count=0;
            for (Band b : Bands){
                if(b.compareTo(band)<0){
                    count=count+1;
                }
            }
            if (count==Bands.size()){
                Bands.add(band);
            }
        }else {
            System.out.println("The collection is empty.");
            Bands.add(band);
        }
    }
    /**
     * выводит элементы, значение поля name которых начинается с заданной подстроки
     * @param name String, фильтруемого элемента
     */
    public void filterStartsWithName(String name){
        if (!Bands.isEmpty()){
            try {
                for (Band band:Bands){
                    if (band.getName().startsWith(name)){
                        System.out.println(band.toString());
                    }
                }
            }catch (NoSuchElementException e){
                System.out.println("No such element in the collection.");
            }

        }else {
            System.out.println("The collection is empty.");
        }
    }

    /**
     * возвращает коллекцию
     */
    public LinkedList<Band> getBands() {
        return Bands;
    }
}
