package models;


import controllers.Utils;

import java.util.LinkedList;
import java.util.List;

public class FlatRepository implements IRepository<Flat> {
    //Attribute
    private List<Flat> flats;

    //Constructor
    public FlatRepository() {
        flats = new LinkedList<Flat>();

    }

    public int getIndexById(Long id) {
        int index = -1;
        //reading the id from the user

        for (int i = 0; i < flats.size(); i++) {
            if (flats.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
        //either normal index or -1 in case nothing was found
    }

    public List<Flat> getFlat() {
        return flats;
    }


    @Override
    public void add(Flat flat) {
        this.flats.add(flat);

    }
}