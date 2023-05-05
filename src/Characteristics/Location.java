package Characteristics;

import java.util.Scanner;

public class Location {
    private long x;
    private int y;
    private String name; //Длина строки не должна быть больше 652, Поле может быть null

    public Location(long x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Location(String ubicacion){
        this.x = getX();
        this.y = getY();
        this.name = ubicacion;
    }
    public Location(){
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Location createLocation(Scanner sc){
        System.out.println("Enter location 'x': ");
        long x = sc.nextLong();
        System.out.println("Enter location 'y': ");
        int y = sc.nextInt();
        System.out.println("Enter name city: ");
        String name = sc.next();

        return new Location(x,y,name);
    }

    public String toString() {
        return "'x': "+x+ " 'y': "+y+" City: "+name;
    }
}
