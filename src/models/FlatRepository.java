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

    public List<Flat> getFlats() {
        return flats;
    }

    public Flat getFlatByIndex(int index) {
        return this.flats.get(index);
    }

    public void setFlatByIndex(int index) {
        this.flats.get(index);
    }

    public void updateName(int index, String newName ){
        this.flats.get(index).setName(newName);

    }

    public void updateArea(int index, int newArea ){
        this.flats.get(index).setArea(newArea);
    }

    public void updateRoom(int index, int newRooms ){
        this.flats.get(index).setNumberOfRooms(newRooms);
    }

    public void updateBalcony(int index, boolean newBalcony ){
        this.flats.get(index).setBalcony(newBalcony);
    }

        public void updateFurnish(int index, Furnish newFurnish  ){
        this.flats.get(index).setFurnish(newFurnish);
    }

    public void updateHouseName(int index, String newHouseName  ){
        this.flats.get(index).getHouse().setName(newHouseName);
    }

    public void updateHouseYear(int index, int newHouseYear){
        this.flats.get(index).getHouse().setYear(newHouseYear);
    }


    @Override
    public void add(Flat flat) {
        this.flats.add(flat);

    }
}