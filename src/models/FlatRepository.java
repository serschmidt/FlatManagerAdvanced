package models;


import java.util.LinkedList;
import java.util.List;

public class FlatRepository implements IRepository<Flat>{
    //Attribute
    private List<Flat> flats;

    //Constructor
    public FlatRepository() {
        flats = new LinkedList<Flat>();
    }

    @Override
    public Flat get(String id) {
        return null;
    }

    @Override
    public void put(String id, Flat obj) {

    }
}