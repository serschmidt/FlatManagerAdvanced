package controllers;

import models.Flat;
import models.FlatRepository;
import models.Furnish;
import utils.MutableFields;

import java.util.List;

public interface IFlatController {

    public List<Flat> show();

    public void addCommand(String lastCommand);
    public void addFlat(Flat obj);

    public FlatRepository getFlatRepo();

    public int findListIndexByFlatID(String args);

    public void removeByIndex(int index);

    public int getIndexById(Long id);


    public void updateName(int index, String newName );

    public void updateArea(int index, int newArea );

    public void updateRoom(int index, int newRooms );

    public void updateBalcony(int index, boolean newBalcony );

    public void updateFurnish(int index, Furnish newFurnish  );

    public void updateHouseName(int index, String newHouseName  );

    public void updateHouseYear(int index, int newHouseYear);

    public void clear();



}