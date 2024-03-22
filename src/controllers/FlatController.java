package controllers;

import models.CSVFileRepository;
import models.Flat;
import models.FlatRepository;
import models.Furnish;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FlatController implements IFlatController {
    private FlatRepository flatRepo;
    private CSVFileRepository fileRepo;
    private LinkedList<String> commands;

    private String filePath = "src/file.csv";

    public FlatController() {
        flatRepo = new FlatRepository();
        fileRepo = new CSVFileRepository(filePath);
    }
    //пока что перманентно


    public void addCommand(String lastCommand) {
        this.commands.add(lastCommand);
        if (this.commands.size() > 15) {
            this.commands.removeFirst();
        }
    }

    public LinkedList<String> getCommands() {
        return commands;
    }

    public List<Flat> getFlatList() {
        return flatRepo.getFlats();

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

    public void removeByIndex(int index) {
        flatRepo.removeByIndex(index);
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

    public void clear() {
        flatRepo.clear();
    }

    public Flat removeHead() {
        return flatRepo.removeHead();
    }


    public void sortByName() {
        flatRepo.sortByName();
    }

    public void sortByArea() {
        flatRepo.sortByArea();
    }

    public void sortByRooms() {
        flatRepo.sortByRooms();
    }

    public void load(String fileLocation) {
        try (FileReader fr = new FileReader(fileLocation)) {
            BufferedReader br = new BufferedReader(fr);
            this.clear();
            do {
                String line = br.readLine();
                if (line == null) // finish, if reached the end of the file
                    break;
                // split the line into a data parts
                Flat newFlat = Flat.parseFromCSV(line);
                this.addFlat(newFlat);
            } while (true);
            flatRepo.sortById();
            int newCount = flatRepo.getNewCount();
            Flat.setCount(newCount);
        } catch (IOException e) {
            System.out.print("ERROR: loading error.");
        }
    }

    public void save(String fileLocation) {
        this.fileRepo.save();

    }
}