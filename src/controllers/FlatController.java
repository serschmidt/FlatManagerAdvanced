package controllers;

import models.Flat;
import models.FlatRepository;
import models.IRepository;

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
    update


    //создаёт файл
    //пишит файл
    //читает файл

    //добавление в list
    //удаление в list
    //очистку


}