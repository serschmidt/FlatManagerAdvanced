package models;

public class House implements Comparable<House> {
    private String name; //can't be null
    private int year; //between 0 and 2030

    //Constructor
    public House(String name, int year) {
        this.name = name;
        if (validateYear(year))
            this.year = year;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static boolean validateYear(int year) {
        if (year >= 1850 && year <= 2030 ) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return " The house is named " + this.name + " and it was built in  " + this.year+"." ;
    }

    @Override
    public int compareTo(House h1) {
        return this.year-h1.getYear();
    }
}