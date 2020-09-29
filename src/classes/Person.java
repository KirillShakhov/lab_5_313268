package classes;

import exceptions.WrongArgumentException;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private String name;            // Поле не может быть null, Строка не может быть пустой
    private String passportID;      // Поле не может быть null
    private Color eyeColor;         // Поле не может быть null
    private Country nationality;    // Поле не может быть null
    // Конструктор
    public Person(String name, String passportID, Color eyeColor, Country nationality){
        this.name = name;
        this.passportID = passportID;
        this.eyeColor = eyeColor;
        this.nationality = nationality;
    }

    // Геттеры
    public String getName(){
        return name;
    }
    public String getPassportID(){
        return passportID;
    }
    public Color getEyeColor(){
        return eyeColor;
    }
    public Country getNationality(){
        return nationality;
    }
    // Сеттеры
    public void setName(String name){
        this.name = name;
    }
    public void setPassportID(String passportID){
        this.passportID = passportID;
    }
    public void setEyeColor(Color eyeColor){
        this.eyeColor = eyeColor;
    }
    public void setNationality(Country nationality){
        this.nationality = nationality;
    }
    // toString
    public String toString(){
        return "Person: {" +
                "name = " + name + '\'' +
                "passportID = " + passportID + '\'' +
                "eyeColor = " + eyeColor + '\'' +
                "nationality = " + nationality +
                "}";
    }
    // equals
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(passportID, person.passportID) &&
                eyeColor == person.eyeColor && nationality == person.nationality;
    }
    // hashCode
    public int hashCode(){
        return Objects.hash(name, passportID, eyeColor, nationality);
    }
}
