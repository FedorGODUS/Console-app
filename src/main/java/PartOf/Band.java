package PartOf;

import java.time.LocalDateTime;
import java.util.Objects;


public class Band implements Comparable<Band>{
    private Integer id = 0;
    private static Integer ID = 0;
    private String name;
    private Coordinates coordinates;
    private Integer numberOfParticipants;
    private Integer albumsCount;
    private String description;
    private MusicGender genre;
    private Label label;
private LocalDateTime date;


{
    id=ID;
    ID++;
}

    public Band(){}
    public Band(String name, Coordinates coordinates, Integer numberOfParticipants, Integer albumsCount, String description, LocalDateTime date, MusicGender genre, Label label){
        this.albumsCount=albumsCount;
        this.coordinates=coordinates;
        this.description=description;
        this.genre=genre;
        this.label=label;
        this.name=name;
        this.numberOfParticipants=numberOfParticipants;
        this.date = date;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAlbumsCount() {
        return albumsCount;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public MusicGender getGenre() {
        return genre;
    }

    public Label getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbumsCount(Integer albumsCount) {
        this.albumsCount = albumsCount;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(MusicGender genre) {
        this.genre = genre;
    }

    public void setNumberOfParticipants(Integer numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "ID "+getId()+
                " NAME " + getName()+
                " COORDINATES "+ getCoordinates()+
                " ALBUMSCOUNT " +getAlbumsCount()+
                " NUMBEROFPATICIPANTS "+getNumberOfParticipants()+
                " LABEL " + getLabel()+
                " DESCRIPTION "+getDescription()+
                " GENRE "+getGenre()+
                " CREATION DATE "+ getDate();



                }

    @Override
    public int hashCode() {
        return Objects.hash(name,coordinates,numberOfParticipants,id,albumsCount,date,label,description,genre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Band band = (Band) o;
        return id.equals(band.id) &&
                name.equals(band.name) &&
                coordinates.equals(band.coordinates) &&
                date.equals(band.date) &&
                albumsCount.equals(band.albumsCount) &&
                genre == band.genre &&
                numberOfParticipants.equals(band.numberOfParticipants)&&
                label.equals(band.label)&&
                description.equals(band.description);
    }

    @Override
    public int compareTo(Band band) {
        return hashCode() - band.hashCode();
    }
}

