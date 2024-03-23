package models;
import controllers.Utils;

import java.io.IOException;
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
        this.id = 10115L * 1000000 + Flat.count; //Berlin postal index + counter
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
        this.id = 10115L *1000000 + Flat.count; //Berlin postal index + counter
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
        if (furnish == null)
            p3 = " The state of its furnishing is unknown at the time.";
        else
            switch (furnish) {
                case DESIGNER:
                    p3 = " The flat has designer furnishing.";
                    break;
                case NONE:
                    p3 = " The flat has no furnishing whatsoever.";
                    break;
                case BAD:
                    p3 = " The flat has unimpressive furnishing.";
                    break;
                case LITTLE:
                    p3 = " The flat has little furnishing.";
                    break;
            }
        String p4 = "";
        if (!(house == null))
            p4 = house.toString();
        return p1+p2+p3+p4;
    }



    public static void setCount(int newCount){
        count = newCount;
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

    public String getCSVLine(){
        //since furnish can be null
        String furnishStr;
        if(furnish!=null)
            furnishStr = furnish.toString();
        else
            furnishStr = "";
        return (id + ";" +
                name + ";" +
                area + ";" +
                numberOfRooms + ";" +
                balcony + ";" +
                furnishStr  + ";" +
                house.getName() + ";" +
                house.getYear()
        );
    }

    public static Flat parseFromCSV(String line) throws IOException {
        String[] parts = line.split(";");
        //id
        if(!Utils.isLong(parts[0])){
            throw new IOException("Error: not a number");}
        long id = Long.parseLong(parts[0]);
        if (!validateId(id)) {
            throw new IOException("Error: wrong ID");}
        //name
        if(!Utils.isString(parts[1])){
            throw new IOException("Error: empty Line");}
        String name = parts[1];

        //area
        if(!Utils.isInt(parts[2])){
            throw new IOException("Error: not a number");}
        int area = Integer.parseInt(parts[2]);
        if (!validateArea(area)) {
            throw new IOException("Error: wrong ID");};

        //number of Rooms
        if(!Utils.isInt(parts[3])){
            throw new IOException("Error: not a number");}
        int nrRooms = Integer.parseInt(parts[3]);
        if (!validateArea(area)) {
            throw new IOException("Error: wrong ID");};

        //balcony
        if(!Utils.isBoolean(parts[4])){
            throw new IOException("Error: not a boolean");}
        boolean balcony = Boolean.parseBoolean(parts[4]);

        //Furnish
        if(!Utils.isEnum(parts[5],Furnish.class) && !(parts[5].isEmpty())){
            throw new IOException("Error: not a Furnish");}
        Furnish furnish;
        if (parts[5].isEmpty()) {
            furnish = null;
        } else {
            furnish = Furnish.valueOf(parts[5]);
        }

        /* old version
        if(!Utils.isEnum(parts[5],Furnish.class)){
            throw new IOException("Error: not a Furnish");}

        Furnish furnish = Furnish.valueOf(parts[5]);

         */

        //house name
        if(!Utils.isString(parts[6])){
            throw new IOException("Error: empty Line");}
        String houseName = parts[6];




        //house year
        if(!Utils.isInt(parts[7])){
            throw new IOException("Error: not a number");}
        int houseYear = Integer.parseInt(parts[7]);
        if (!House.validateYear(houseYear)) {
            throw new IOException("Error: wrong ID");};

        House house = new House(houseName, houseYear);

        Flat flat = new Flat(id, name, area, nrRooms, balcony, furnish, house);
        return flat;
    }

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

class FlatIdComparator implements Comparator<Flat> {
    @Override
    public int compare(Flat f1, Flat f2) {
        return (int)(f1.getId()-f2.getId());
    }
}