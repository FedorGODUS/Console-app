package Control;


import PartOf.Band;
import PartOf.Coordinates;
import PartOf.Label;
import PartOf.MusicGender;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.LinkedList;


/**
 * Работает с файлами
 *
 * @author Tsvetkov Fedor
 * @version 0
 * @since 0
 */
public class FileManager {
    /**
     * Constructor FileManager
     */
    public FileManager(){

    }

    /**
     * Читает csv файл, и возвращает коллекцию bands из этого файла
     *
     * @param file csv файл, в котором находится коллекция
     * @return Коллекция bands
     */
    public LinkedList<Band> readFile(File file) {
        LinkedList<Band> bands = new LinkedList<>();
        try(BufferedReader br = Files.newBufferedReader(Paths.get(file.toURI()), StandardCharsets.UTF_8)){
            CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT);
            for (CSVRecord csvRecord : csvParser) {
                String name = csvRecord.get(0);
                Long X =Long.parseLong(csvRecord.get(1));
                Long Y =Long.parseLong(csvRecord.get(2));
                Integer NoP =Integer.parseInt(csvRecord.get(3));
                Integer AC = Integer.parseInt(csvRecord.get(4));
                String Des = csvRecord.get(5);
                MusicGender musicGender = MusicGender.valueOf(csvRecord.get(6));
                double Sales = Double.parseDouble(csvRecord.get(7));
                bands.add(new Band(name,new Coordinates(X,Y),NoP,AC,Des, LocalDateTime.now(),musicGender,new Label(Sales)));
            }
        }catch (IOException e){
            System.out.println("There is a mistake.");
        }

return bands;
    }


    /**
     * Сохраняет коллекцию в изначальный csv файл
     *
     * @param collection collection
     */
    public void saveFile(Collection collection){
        try {
            LinkedList<Band> bands = new LinkedList<>(collection.getBands());
            File file = new File("D:\\laba5ver3\\src\\main\\java\\Inport\\forlab.csv");
            FileOutputStream fileOutputStream =new FileOutputStream(file);
            if (bands.size()!=0){
            for (Band band: bands){
                fileOutputStream.write((band.getId()+","+band.getName()+","+band.getCoordinates()+","+band.getNumberOfParticipants()+","+
                        band.getAlbumsCount()+","+band.getDescription()+","+band.getDate()+","+band.getGenre()+","+band.getLabel()+"\n").getBytes());
            }
            fileOutputStream.close();
            }
            else {
                System.out.println("U can not do it." +
                        "The collection is empty.");
            }





        }catch (IOException e){
            System.out.println("mistake");
        }
        }
}


