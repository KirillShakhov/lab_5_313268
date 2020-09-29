package classes;

import java.time.LocalDateTime;

public class Product {
    private Integer id;                         // Поле не может быть null, Значение поля должно быть больше 0
                                                // Значение этого поля должно быть уникальным
                                                // Значение этого поля должно генерироваться автоматически
    private String name;                        // Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates;            // Поле не может быть null
    private java.time.LocalDateTime creationDate;   // Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float price;                        // Поле не может быть null, Значение поля должно быть больше 0
    private String partNumber;                  // Поле не может быть null, Строка не может быть пустой,
                                                // Длина строки должна быть не меньше 23
                                                // Длина строки не должна быть больше 68
    private UnitOfMeasure unitOfMeasure;        // Поле не может быть null
    private Person owner;                       // Поле может быть null

    // Конструктор
    public Product(Integer id, String name, Coordinates coordinates, Float price, String partNumber,
                   UnitOfMeasure unitOfMeasure, Person owner){
        this.id = IDGenerator.generateID();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.price = price;
        this.partNumber = partNumber;
        this.unitOfMeasure = unitOfMeasure;
        this.owner = owner;
    }
    // Геттеры
    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Coordinates getCoordinates(){
        return coordinates;
    }
    public LocalDateTime getCreationDate(){
        return creationDate;
    }
    public Float getPrice(){
        return price;
    }
    public String getPartNumber(){
        return partNumber;
    }
    public UnitOfMeasure getUnitOfMeasure(){
        return unitOfMeasure;
    }
    public Person getOwner(){
        return owner;
    }
    // Сеттеры
    public void setId(Integer id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }
    public void setCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
    }
    public void setPrice(Float price){
        this.price = price;
    }
    public void setPartNumber(String partNumber){
        this.partNumber = partNumber;
    }
    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure){
        this.unitOfMeasure = unitOfMeasure;
    }
    public void setOwner(Person owner){
        this.owner = owner;
    }
    // toString
    public String toString(){
        return "Product: {" +
                "id = " + id + '\'' +
                "name = " + name + '\'' +
                "coordinates = " + coordinates + '\'' +
                "creationDate = " + creationDate + '\'' +
                "price = " + price + '\'' +
                "partNumber = " + partNumber + '\'' +
                "unitOfMeasure = " + unitOfMeasure + '\'' +
                "owner = " + owner +
                "}";
    }
}
