package models;
import java.util.Comparator;

public class Flat implements Comparable<Flat> {

    private static int count = 1;

    private long id; //Field must be bigger than zero,
    //the value must be unique,
    //the value must be generated automatically
    private String name; //can't be null or empty
    private Integer area; //can't be null, must be bigger than zero
    private Integer numberOfRooms; //maximum value 8, must be bigger than zero
    private boolean balcony;
    private Furnish furnish; //CAN be null
    private House house; //can't be null

    //FLAT CONSTRUCTOR - with furniture
    public Flat(String name, Integer area, Integer numberOfRooms, boolean balcony, Furnish furnish, House house) {
        this.id = 10115 * 1000000 + Flat.count; //Berlin postal index + counter
        Flat.count++;

        this.name = name;
        if (validateArea(area))
            this.area = area;
        if (validateNumberOfRooms(numberOfRooms))
            this.numberOfRooms = numberOfRooms;
        this.balcony = balcony;
        this.furnish = furnish;
        this.house = house;
    }

    //FLAT CONSTRUCTOR - without furniture
    public Flat(String name, Integer area, Integer numberOfRooms, boolean balcony, House house) {
        this.id = 10115 * 1000000 + Flat.count; //Berlin postal index + counter
        Flat.count++;

        this.name = name;
        if (validateArea(area))
            this.area = area;
        if (validateNumberOfRooms(numberOfRooms))
            this.numberOfRooms = numberOfRooms;
        this.balcony = balcony;
        this.furnish = null;
        this.house = house;
    }


    //FLAT CONSTRUCTOR - for READING from a file
    public Flat(long id, String name, Integer area, Integer numberOfRooms, boolean balcony, Furnish furnish, House house) {

        if (validateId(id))
            this.id = id;
        this.name = name;
        if (validateArea(area))
            this.area = area;
        if (validateNumberOfRooms(numberOfRooms))
            this.numberOfRooms = numberOfRooms;
        this.balcony = balcony;
        this.furnish = furnish;
        this.house = house;
    }

    //Comparable by size
    @Override
    public int compareTo(Flat flat) {
        return this.area-flat.getArea();
    }

    @Override
    public String toString() {
        String p1 = "A flat " +
                "with id number " + id +
                ", named " + name + '\'' +
                ", " + area +
                " square meters, with " + numberOfRooms +
                " rooms.";
        String p2 = "";
        if (balcony) {
            p2 = " It has a balcony.";
        } else {
            p2 = " It has no balcony.";
        }
        String p3 = "";
        if (!(furnish == null))
            p3 = " This flat has "+furnish+" furnishing.";
        String p4 = "";
        if (!(house == null))
            p4 = house.toString();
        return p1+p2+p3+p4;
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }       //ID can only be viewed, not edited

    public static boolean validateId(long id) {
        if(id>10115 * 1000000)
            return true;
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //validator for name not needed

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public static boolean validateArea (int area) {
        if (area>0 && area <=200) {
            return true;
        }
        return false;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public static boolean validateNumberOfRooms(int number) {
        if (number>0 && number<=8)
            return true;
        return false;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    //validating balcony not needed

    public Furnish getFurnish() {
        return furnish;
    }

    public void setFurnish(Furnish furnish) {
        this.furnish = furnish;
    }

    //validating furnish is not needed

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    //House validation done by HOUSE model

}

class FlatAreaComparator implements Comparator<Flat> {
    @Override
    public int compare(Flat f1, Flat f2) {
        return f1.getArea()-f2.getArea();
    }
}

class FlatRoomNumberComparator implements Comparator<Flat> {
    @Override
    public int compare(Flat f1, Flat f2) {
        return f1.getNumberOfRooms()-f2.getNumberOfRooms();
    }
}

class FlatNameComparator implements Comparator<Flat> {
    @Override
    public int compare(Flat f1, Flat f2) {
        return f1.getName().compareTo(f2.getName());
    }
}