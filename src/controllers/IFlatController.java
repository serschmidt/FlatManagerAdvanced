package controllers;

import models.Flat;
import models.FlatRepository;
import models.Furnish;

import java.util.LinkedList;
import java.util.List;

public interface IFlatController {

    public List<Flat> show();

    public void addCommand(String lastCommand);

    public LinkedList<String> getCommands();

    public List<Flat> getFlatList();

    public FlatRepository getFlatRepo();

    public void addFlat(Flat obj);


    public int getIndexById(Long id);

    public void removeByIndex(int index);

    public void updateName(int index, String newName );

    public void updateArea(int index, int newArea );

    public void updateRoom(int index, int newRooms );

    public void updateBalcony(int index, boolean newBalcony );

    public void updateFurnish(int index, Furnish newFurnish  );

    public void updateHouseName(int index, String newHouseName  );

    public void updateHouseYear(int index, int newHouseYear);

    public void clear();

    public Flat removeHead();

    public void sortByName();

    public void sortByArea();

    public void sortByRooms();

    public void save(String fileLocation);

    public void load(String fileLocation);

}
