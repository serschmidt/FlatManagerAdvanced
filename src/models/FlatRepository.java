package models;


import controllers.Utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FlatRepository implements IRepository<Flat> {
    //Attribute
    private LinkedList<Flat> flats;

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

    public void updateName(int index, String newName) {
        this.flats.get(index).setName(newName);

    }

    public void updateArea(int index, int newArea) {
        this.flats.get(index).setArea(newArea);
    }

    public void updateRoom(int index, int newRooms) {
        this.flats.get(index).setNumberOfRooms(newRooms);
    }

    public void updateBalcony(int index, boolean newBalcony) {
        this.flats.get(index).setBalcony(newBalcony);
    }

    public void updateFurnish(int index, Furnish newFurnish) {
        this.flats.get(index).setFurnish(newFurnish);
    }

    public void updateHouseName(int index, String newHouseName) {
        this.flats.get(index).getHouse().setName(newHouseName);
    }

    public void updateHouseYear(int index, int newHouseYear) {
        this.flats.get(index).getHouse().setYear(newHouseYear);
    }

    public void removeByIndex(int index) {
        this.flats.remove(index);
    }

    public void clear() {
        this.flats.clear();
    }

    public Flat removeHead() {
        return this.flats.remove(0);
    }

    @Override
    public void add(Flat flat) {
        this.flats.add(flat);

    }

    public void sortByName() {
        FlatNameComparator compName = new FlatNameComparator();
        Collections.sort(flats, compName);
    }

    public void sortByArea() {
        //implemented - sorting by Area using Comparable
        Collections.sort(flats);

        /*
        //also possible - sorting by Area using FlatAreaComparator
        FlatAreaComparator compArea = new FlatAreaComparator();
        Collections.sort(flats, compArea);
         */
    }

    public void sortByRooms() {
        FlatRoomNumberComparator compRooms = new FlatRoomNumberComparator();
        Collections.sort(flats, compRooms);
    }

    public int getNewCount() {
        return (int) flats.getLast().getId() - 10115* 1000000 + 1;
    }

    public void sortById() {
        FlatIdComparator compId = new FlatIdComparator();
        Collections.sort(flats, compId);
    }

    @Override
    public Flat get(String name) {
        return null;
    }
}