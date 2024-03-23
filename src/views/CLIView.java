package views;


import controllers.FlatController;
import controllers.IFlatController;
import controllers.Utils;
import models.Flat;
import models.Furnish;
import models.House;

import java.io.File;
import java.util.*;

import utils.MutableFields;
import utils.SortableFields;

public class CLIView {      //command line interface

    //взаимодействие с командной стракой происходит тут
    private FlatController flatController;
    private Scanner scanner;
    private Date date;

    private String userName;

    public CLIView() {
        flatController = new FlatController();
        scanner = new Scanner(System.in);
        date = new Date();
    }

    public void startCommunication(String filePath) {
        String cmd;
        //load default set of flats
        flatController.load(filePath);
        //welcome and offer to save file
        System.out.print(
                "Welcome to the ADVANCED FLAT MANAGER!\n" +
                        "With this application you'll be able to store information about your flats, no fuss. \n" +
                        "Please, enter your name: \n");
        this.userName = scanner.nextLine();
        //String savefile = "database/"+userName.toLowerCase()+"_savefile.csv";
        String savefile = "src/"+userName.toLowerCase()+"_savefile.csv";
        /*
        System.out.println("Checking if you already have a saved file under your name...");
        File f = new File(savefile);
        if(f.exists() && !f.isDirectory()) {
            System.out.println("There is a file under you name in our database already! " +
                    "If you want to load it, type yes/ja.");
            String response = scanner.nextLine().toLowerCase();
            if (response.equals("yes") || response.equals("ja")) {
                this.addCommand("load");
                this.load(savefile);
                System.out.println("Done! You can continue working with your file.");
            } else {
                System.out.println("As you wish, but consider saving the results of your session in the future.");
            }
        } else {
            System.out.println("It seems you haven't saved any files with us yet. " +
                    "Carry on, but consider saving the results of your session in the future.");
        }

         */



        System.out.print(userName + ", " + "following commands are available to your: \n");
        help();

        do {
            //reading new command
            System.out.println("\n \nPlease, "+userName+", type in what you need...");

            String[] lineInParts = null;
            String arg = null;
            cmd = scanner.nextLine().toLowerCase();

            if (cmd.contains(" ")) {
                lineInParts = cmd.split(" ");
                cmd = lineInParts[0];
                arg = lineInParts[1];
            }

            //switch between possible commands
            switch (cmd) {
                case "exit":
                    System.out.println("See you next time! Good Bye");
                    System.exit(0);
                    break;

                case "help":
                    this.addCommand(cmd);
                    this.help();
                    break;

                case "info":
                    this.addCommand(cmd);
                    this.startInfoCommand();     //flatRepository метод
                    break;

                case "show":
                    this.addCommand(cmd);
                    this.show();
                    break;

                case "add":
                    this.addCommand(cmd);
                    this.addFlat();
                    break;

                case "update":
                    this.addCommand(cmd);
                    this.updateById(arg);
                    break;

                case "remove":
                    this.addCommand(cmd);
                    this.removeById(arg);
                    break;

                case "clear":
                    this.addCommand(cmd);
                    this.clear();
                    break;

                case "remove_head":
                    this.addCommand(cmd);
                    this.removeHead();
                    break;

                case "history":
                    this.addCommand(cmd);
                    this.history();
                    break;

                case "filter_balcony":
                    this.addCommand(cmd);
                    this.filterBalcony();
                    break;

                case "print_ascending":
                    this.addCommand(cmd);
                    this.printAscending();
                    break;

                case "load":
                    this.addCommand(cmd);
                    //this.load(savefile);
                    this.load(filePath);
                    break;

                case "save":
                    this.addCommand(cmd);
                    //this.save(savefile);
                    this.load(filePath);
                    break;

                default:
                    System.err.println("Unacceptable input!");

            }
        } while (true);

    }

    public void help() {
        // Roman
        System.out.println(
                "help: the list of all commands \n" +
                        "info: provide information about this manager \n" +
                        "show: show all flats in the list: \n" +
                        "add: add new flat to the list \n" +
                        "update : update the flat with id {id} \n" +
                        "remove : remove the flat with id {id} from the list \n" +
                        "clear: delete all flats from the list \n" +
                        "exit: exit program \n" +
                        "remove_head: remove first flat fromt he list and show it \n" +
                        "history: show the last 15 commands \n" +
                        "filter_balcony: show all flats with/without balcony \n" +
                        "print_ascending: show the list of flats in ascending order\n" +
                        "save: write the Data of the Flats into a file.\n" +
                        "load: get the list of flats from file"
        );
    }

    //startInfoCommand
    public void startInfoCommand() {
        //Roman
        System.out.println("This FLAT MANAGER was initialized on " + this.date + ".");
        int flatSize = getFlatsSize();
        System.out.println("At the moment, the FLAT MANAGER has " + flatSize + " of flats saved.");
        if (flatSize < 10)
            System.out.println("Hardly impressive - but there is room for improvement");
        if (flatSize >= 10)
            System.out.println("That's a lot of flats!");
        System.out.println("FLAT MANAGER is the result of collective effort by Team 1, Cohort 40_2 of AIT TR course.");
        System.out.println("- Sergej Schmidt");
        System.out.println("- Eugeny Davydov");
        System.out.println("- Roman Sheludko");
        System.out.println("If you have any suggestions and complaints, please let us know!");
        System.out.println("Our email is: we-dont-care-get-lost@gmail.com!");
        System.out.println("We eagerly await your feedback!");
    }

    private int getFlatsSize(){
        return flatController.getFlatRepo().getFlats().size();
    }

    public void show() {
        System.out.println("Showing all flats:");
        List<Flat> flats = flatController.getFlatList();
        for (Flat flat : flats) {
            System.out.println(flat);
        }
        //Switch - Case проверка команд
    }

    public void addFlat() {
        System.out.println("Add a new flat!");
        String addName = getFlatName();
        int addArea = getFlatArea();
        int addNrRooms = getFlatNrRooms();
        boolean addBalcony = getFlatBalcony();
        Furnish furniture = getFlatFurniture();
        House h1 = getHouse();
        //add new FLat
        Flat flat = new Flat(addName, addArea, addNrRooms, addBalcony, furniture, h1);
        flatController.addFlat(flat);
        System.out.println("Following flat has been added to the list:");
        System.out.println(flat);
    }

    private String getFlatName() {
        String flatName;
        do {
            System.out.println("Enter flat's name...");
            flatName = scanner.nextLine();
            if (!Utils.isString(flatName)) {
                System.err.println("Name can't be empty.");
            } else {
                return flatName;
            }
        } while (true);
    }

    private int getFlatArea() {
        String lineIn;
        int addArea = -1;
        do {
            System.out.println("Enter flat's area in square meters...");
            lineIn = scanner.nextLine();
            if (Utils.isInt(lineIn)) {
                addArea = Integer.valueOf(lineIn);
                if (Flat.validateArea(addArea)){
                    System.out.println("Area accepted");
                    break;
                }else {
                    System.err.println("Unacceptable area, must be between 0 and 200 square meters.");
                }
            } else {
                System.err.println("Unacceptable entry, a number is required.");
            }
        } while (true);
        return addArea;
    }

    //auxiliary method to allow user to enter the number of flat's rooms
    private int getFlatNrRooms() {
        String lineIn;
        int addNrRooms = -1;
        do {
            System.out.println("Enter the number of flat's rooms...");
            lineIn = scanner.nextLine();
            if (Utils.isInt(lineIn)) {
                addNrRooms = Integer.valueOf(lineIn);
                if (Flat.validateNumberOfRooms(addNrRooms)) {
                    //continue here;
                    //break to the cycle's beginning doesn't work
                    break;
                }
                System.out.println("Unacceptable entry, provide number of rooms between 0 and 8.");
            } else {
                System.out.println("Unacceptable entry, must be a number of rooms between 0 and 8.");
            }
        } while (true);
        return addNrRooms;
    }

    //auxiliary method to allow user to enter whether the flat has a balcony
    private boolean getFlatBalcony() {
        String lineIn;
        boolean addBalcony = false;
        do {
            System.out.println("Please enter whether the flat has a balcony");
            System.out.println("yes/ja  or  no/nein");
            lineIn = scanner.nextLine().toLowerCase();
            if (lineIn.equals("yes") || lineIn.equals("ja")) {
                addBalcony = true;
                break;
            } else if (lineIn.equals("no") || lineIn.equals("nein")) {
                addBalcony = false;
                break;
            } else {
                System.err.println("Unacceptable entry, please try again");
            }
        } while (true);
        return addBalcony;
    }

    //auxiliary method to allow user to grade the flat's furniture
    private Furnish getFlatFurniture() {
        String lineIn;
        Furnish furniture = null;
        do {
            System.out.println("If you wish, determine the room's furnishing.");
            System.out.println("yes/ja to continue, no/nein to skip");
            lineIn = scanner.nextLine().toLowerCase();
            if (lineIn.equals("yes") || lineIn.equals("ja")) {
                do {
                    System.out.println("Determine the level of furnishing:  ");
                    System.out.println("DESIGNER,\n" +
                            "    NONE,\n" +
                            "    BAD,\n" +
                            "    LITTLE");
                    lineIn = scanner.nextLine().toUpperCase();
                    switch (lineIn) {
                        case "DESIGNER":
                            return Furnish.DESIGNER;
                        case "NONE":
                            return Furnish.NONE;
                        case "BAD":
                            return Furnish.BAD;
                        case "LITTLE":
                            return Furnish.LITTLE;
                        default:
                            System.err.println("Unacceptable entry, please try again.");
                    }
                } while (true);
            } else if (lineIn.equals("no") || lineIn.equals("nein")) {
                return furniture;
            } else {
                System.err.println("Unacceptable entry, please try again.");
            }
        } while (true);
    }


    //auxiliary method to add a new House to a building
    private House getHouse() {
        House house = new House(getHouseName(), getHouseYear());
        return house;
    }

    //auxiliary method to allow user to provide house's building year
    private int getHouseYear() {
        while (true) {
            System.out.println("Enter the house's building year:");
            String line = scanner.nextLine();
            if (!Utils.isInt(line)) {
                System.err.println("That's no number!");
                continue;
            }
            int year = Integer.parseInt(line);
            if (House.validateYear(year)) {
                return year;
            }
            System.err.println("The year must be lower than 2030 and higher than 1850!");
        }
    }

    //auxiliary method to allow user to provide house's name
    private String getHouseName() {
        while (true) {
            System.out.println("Please enter the house's name: ");
            String line = scanner.nextLine();
            if (!Utils.isString(line)) {
                System.err.println("That's an empty line!");
                continue;
            }
            return line;
        }
    }



    //UPDATE FLAT BY ID
    public void updateById(String args) {
        //read ID, find if ithere is a flat with such id, return index
        if (!Utils.isLong(args)) {
            System.err.println("Unacceptable entry, numbers required!");
            return;
        }
            //searching got the flat with this ID and grabbing its index
            long id = Long.valueOf(args);


        int index = flatController.getIndexById(id);
        //if no such flat - get out
        if (index == -1) {
            System.err.println("There is no flat with such ID!");
            return;
        }
        boolean looper = true;
        do {
            // ask for parameter to change
            System.out.println("Please let us know which parameter of the apartment do you wish to change.");
            System.out.println("Acceptable parameters are: \n" +
                    "name, \n" +
                    "area, \n" +
                    "rooms, \n" +
                    "balcony, \n" +
                    "furnish, \n" +
                    "house");
            System.out.println("Type 'done' if you wish to stop updating the apartment.");
            String lineIn = scanner.nextLine().toUpperCase();
            if (!Utils.isEnum(lineIn, MutableFields.class)) {
                System.out.println("не корректно");
                continue;
            }
            MutableFields changeField = MutableFields.valueOf(lineIn);
            //switch case launching add-commands to read the values and apply them

            // to the flat with index [index]
            switch (changeField) {

                case NAME:
                    System.out.println("Please enter the new name:");
                    lineIn = scanner.nextLine();
                    if (!Utils.isString(lineIn)){
                        System.out.println("Error: Empty Line");
                        return;
                    }
                    flatController.updateName(index, lineIn);
                    System.out.print("Updated Flat: " + flatController.getFlatRepo().getFlatByIndex(index));
                    break;
                case AREA:
                    System.out.println("Please enter the new Area:");
                    lineIn = scanner.nextLine();
                    if (!Utils.isInt(lineIn)){
                        System.out.println("Error: not a Number");
                        return;
                    }
                    int area = Integer.parseInt(lineIn);
                    if (!Flat.validateArea(area)){
                        System.out.println("Error: unacceptable Area");
                        return;
                    }
                    flatController.updateArea(index, area);
                    System.out.print("Updated Flat: " + flatController.getFlatRepo().getFlatByIndex(index));
                    break;


                case ROOMS:
                    System.out.println("Please enter the new number of rooms:");
                    lineIn = scanner.nextLine();
                    if (!Utils.isInt(lineIn)){
                        System.out.println("Error: not a Number");
                        return;
                    }
                    int nrRooms = Integer.parseInt(lineIn);
                    if (!Flat.validateArea(nrRooms)){
                        System.out.println("Error: unacceptable number of rooms");
                        return;
                    }
                    flatController.updateRoom(index, nrRooms);
                    System.out.print("Updated Flat: " + flatController.getFlatRepo().getFlatByIndex(index));
                    break;

                case BALCONY:
                    System.out.println("Please enter weather the Flat has a Balcony:");
                    lineIn = scanner.nextLine();
                    if (!Utils.isBoolean(lineIn)){
                        System.out.println("Error: not true or false");
                        return;
                    }
                    boolean newBalcony = Boolean.parseBoolean(lineIn);
                    flatController.updateBalcony(index, newBalcony);
                    System.out.print("Updated Flat: " + flatController.getFlatRepo().getFlatByIndex(index));
                    break;

                case FURNISH:
                    System.out.println("Please enter which Furnish does the Flat have:");
                    lineIn = scanner.nextLine();
                    if (!Utils.isEnum(lineIn,Furnish.class)){
                        System.out.println("Error: not right furnish");
                        return;
                    }
                    Furnish newFurnish = Furnish.valueOf(lineIn);
                    flatController.updateFurnish(index, newFurnish);
                    System.out.print("Updated Flat: " + flatController.getFlatRepo().getFlatByIndex(index));
                    break;

                case HOUSE:
                    System.out.println("Please enter the new name of the House:");
                    lineIn = scanner.nextLine();
                    if (!Utils.isString(lineIn)){
                        System.out.println("Error: Empty Line");
                        return;
                    }
                    String newHouseName = lineIn;
                    flatController.updateHouseName(index, newHouseName);


                    System.out.println("Please enter the new Year of a House:");
                    lineIn = scanner.nextLine();
                    if (!Utils.isInt(lineIn)){
                        System.out.println("Error: not a Number");
                        return;
                    }
                    int newYear = Integer.parseInt(lineIn);
                    if (!House.validateYear(newYear)){
                        System.out.println("Error: please enter correct Year between 1850 and 2030");
                        return;
                    }
                    flatController.updateHouseYear(index, newYear);
                    System.out.print("Updated Flat: " + flatController.getFlatRepo().getFlatByIndex(index));
                    break;

                case DONE:
                    looper = false;
                    break;
                default:
                    System.err.println("Unacceptable entry!");
            }

        } while (looper);

    }


    //REMOVE A FLAT BY ID
    public void removeById(String args) {
        //read ID, find if it here is a flat with such id, return index
        if (!Utils.isLong(args)){
            System.out.println("ERROR: ID should be a number");
        }
        long id = Long.parseLong(args);
        int index = flatController.getIndexById(id);
        if (index != -1) {
            flatController.removeByIndex(index);
            System.out.println("Flat with ID " + args + " removed from the list!");
        } else {
            System.out.println("ERROR: no apartment with such ID found!");
        }
    }

    public void addCommand(String command) {
        flatController.addCommand(command);
    }

    //CLEAR the list - with a safeguard against accidental clearing
    public void clear() {
        System.out.println("WARNING: this command will delete all flats from the list!");
        System.out.println("Are you sure? The process is irreversible! Type 'ja' or 'yes' to confirm.");
        String lineIn = scanner.nextLine().toLowerCase();
        if (lineIn.equals("ja") || lineIn.equals("yes")) {
            flatController.clear();
            System.out.println("All flats deleted");
        } else {
            System.out.println("ABORT: list clearing aborted!");
        }
    }

    public void removeHead() {
        System.out.println("Removing the first flat in the list!");
        System.out.println("This is what it was:");
        System.out.println(flatController.removeHead());
    }

    public void history() {
        LinkedList<String> commandList = flatController.getCommands();
        System.out.println("The last "+commandList.size()+" commands were:");
        for (String str : commandList) {
            System.out.println(str);
        }
    }

    public void filterBalcony() {
        System.out.println("Show all flats with or without balconies! \n " +
                "with / mit = with a balcony, without / ohne = without one.");
        String lineIn = scanner.nextLine().toLowerCase();
        List<Flat> flats = flatController.getFlatList();
        if (lineIn.equals("with") || lineIn.equals("mit")) {
            System.out.println("Showing all flats with a balcony:");
            for (Flat flat : flats) {
                if (flat.isBalcony()) {
                    System.out.println(flat);
                }
            }
        } else if (lineIn.equals("without") || lineIn.equals("ohne")) {
            System.out.println("Showing all flats without a balcony:");
            for (Flat flat : flats) {
                if (!flat.isBalcony()) {
                    System.out.println(flat);
                }
            }
        } else {
            System.out.println("ERROR: Unacceptable entry...");
        }
    }

    public void printAscending () {
        do {
            // ask for parameter to change
            System.out.println("Please let us know by which parameter do you wish to sort the flats.");
            System.out.println("Acceptable parameters are: \n" +
                    "name, \n" +
                    "area, \n" +
                    "rooms (for the number of rooms)");
            System.out.println("Print 'done' when you wish to return to other functions.");
            String lineIn = scanner.nextLine().toUpperCase();
            if (!Utils.isEnum(lineIn, SortableFields.class)) {
                System.out.println("ERROR: invalid sorting parameter!");
                System.out.println("Try again.");
                continue;
            }
            SortableFields changeField = SortableFields.valueOf(lineIn);
            //switch case chooses by which parameter the flats are sorted
            switch (changeField) {
                case NAME:
                    System.out.println("Flat list sorted by name:");
                    flatController.sortByName();
                    show();
                    break;
                case AREA:
                    System.out.println("Flat list sorted by area:");
                    flatController.sortByArea();
                    show();
                    break;
                case ROOMS:
                    System.out.println("Flat list sorted by number of rooms:");
                    flatController.sortByRooms();
                    show();
                    break;
                case DONE:
                    System.out.println("Very well, let's do something else...");
                    return;
                default:
                    System.out.println("ERROR: unacceptable entry! Try again.");
            }
        } while (true);
    }

    public void load(String fileLocation) {
        System.out.println("Old flats will be deleted before loading new ones from a file "+fileLocation);
        flatController.load(fileLocation);
        System.out.println("List of flats was loaded successfully.");
    }

    public void save(String fileLocation) {

        System.out.println("The flat list will be saved to a file " + fileLocation);
        flatController.save(fileLocation);
        System.out.println("List of flats was saved successfully.");
    }
}


//
//Задание на сейчас:
//
//выделить весь пользовательский ввод вывод в отдельный класс CLIView
//выделить все проверки пограничных значений в отдельные статические методы в целевых классах
//в CLIView преобразовывать данные к нужным типам
//в CLIView вызывать методы валидации для введенных данных
//
//CLIView:
//
//метод с switch-case выбора команд
//методы-обработчики команд
//методы опрашивания отдельных значений:
//        do {
//
//areaLine = scanner.nextLine
//
//if (!Utils.isInt(areaLine)) {
//
//        “Значение невалидно”
//
//        continue
//
//        }
//
//area = Integer.parseInt(areaLine)
//
//if (Flat.validateArea(area)) {
//
//        “Значение невалидно”
//
//        continue
//
//        }
//
//        return area;
//
//} while(true);