package controllers;

import models.Flat;
import models.FlatRepository;
import models.IRepository;

import java.util.LinkedList;

public class FlatController implements IFlatController {
    private IRepository<Flat> flatRepo;

    private LinkedList<String> commands;


    public void addCommand(String lastCommand) {
        commands.add(lastCommand);
        if (commands.size() > 15) {
            commands.removeFirst();
        }
    }


    public FlatController() {
        flatRepo = new FlatRepository();
    }

    @Override
    public void show(){
        System.out.println("dfg");

    }
    @Override
    public void add(Flat flat) {
        flatRepo.put("1212", flat);
    }

public void addFlat(){

}


    //создаёт файл
    //пишит файл
    //читает файл

    //добавление в list
    //удаление в list
    //очистку


}