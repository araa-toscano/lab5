package Characteristics;

import java.util.Scanner;

public class Coordinates {
    private long x;
    private long y; //Значение поля должно быть больше -642, Поле не может быть null

    public Coordinates(Long x, Long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }
    public void setX(long x) {
        this.x = x;
    }
    public long getY() {
        return y;
    }
    public void setY(long y) {
        this.y = y;
    }

    public static Coordinates createCoordinates(Scanner sc){
        System.out.println("Enter coordinate 'x': ");
        Long x = sc.nextLong();
        System.out.println("Enter coordinate 'y': ");
        long y= sc.nextLong();
        while (y < -642){
            System.out.println("You have entered a wrong value");
            y = sc.nextLong();
        }
        return new Coordinates(x, y);
    }

    @Override
    public String toString() {
        return "'x': "+x+ " 'y': "+y;
    }
}
