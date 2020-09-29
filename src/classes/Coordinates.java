package classes;

public class Coordinates {
    private int x;
    private long y;
    // Конструктор
    public Coordinates(int x, long y){
        this.x = x;
        this.y = y;
    }
    // Геттеры
    public int getX(){
        return x;
    }
    public long getY(){
        return y;
    }
    // Сеттеры
    public void setX(int x){
        this.x = x;
    }
    public void setY(long y){
        this.y = y;
    }
    // toString
    public String toString(){
        return "Coordinates: {" + "x = " + x + ", y = " + y + "}";
    }
}
