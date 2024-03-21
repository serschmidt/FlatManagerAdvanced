package controllers;

import models.Flat;
import models.FlatRepository;
import models.Furnish;
import utils.MutableFields;

import java.util.LinkedList;
import java.util.List;

public class FlatController implements IFlatController {
    private FlatRepository flatRepo;

    public FlatController() {
        flatRepo = new FlatRepository();
    }

    private LinkedList<String> commands;


    public void addCommand(String lastCommand) {
        this.commands.add(lastCommand);
        if (this.commands.size() > 15) {
            this.commands.removeFirst();
        }
    }


    @Override
    public List<Flat> show() {
        return flatRepo.getFlat();

    }
@Override
    public FlatRepository getFlatRepo() {
        return flatRepo;
    }

    @Override
    public void addFlat(Flat flat) {
        flatRepo.add(flat);
    }

    //asks for a flat id, then looks which index does it have in flats List
    @Override
    public int getIndexById(Long id){
        return flatRepo.getIndexById(id);
    }
    public void updateName(int index, String newName ){
    flatRepo.updateName(index, newName);
    }

    public void updateArea(int index, int newArea ){
        flatRepo.updateArea(index,newArea);
    }

    public void updateRoom(int index, int newRooms ){
        flatRepo.updateRoom(index,newRooms);
    }

    public void updateBalcony(int index, boolean newBalcony ){
        flatRepo.updateBalcony(index,newBalcony);
    }

    public void updateFurnish(int index, Furnish newFurnish  ){
        flatRepo.updateFurnish(index, newFurnish);
    }

    public void updateHouseName(int index, String newHouseName  ){
        flatRepo.updateHouseName(index,newHouseName);
    }

    public void updateHouseYear(int index, int newHouseYear){
        flatRepo.updateHouseYear(index,newHouseYear);
    }



    //создаёт файл
    //пишит файл
    //читает файл

    //добавление в list
    //удаление в list
    //очистку


}