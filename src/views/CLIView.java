package views;


import controllers.FlatController;
import controllers.IFlatController;
import models.Flat;

import java.util.Locale;
import java.util.Scanner;

public class CLIView {      //command line interface

    //взаимодействие с командной стракой происходит тут
    private IFlatController flatController;

    public CLIView(){
        flatController = new FlatController();
    }

    public void startCommunication() {
        Scanner scanner = new Scanner(System.in);
        String cmd ;
        boolean loopIsTrue= true;

        do {
            //reading new command
            System.out.println("\n \nPlease type in what you need...");

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
                    loopIsTrue = false;
                    break;

                case "help":
                    addCommand(cmd);
                    help();
                    break;

                case "info":
                    addCommand(cmd);
                    startInfoCommand();     //flatRepository метод
                    break;

                case "show":
                    addCommand(cmd);
                    flatController.show();
                    break;

                case "add":
                    addCommand(cmd);
                    flatController.addFlat();
                    break;

                case "update":
                    addCommand(cmd);
                    flatController.updateById(arg);
                    break;

                case "remove":
                    addCommand(cmd);
                    flatController.removeById(arg);
                    break;

                case "clear":
                    addCommand(cmd);
                    flatController.clear();
                    break;

                case "remove_head":
                    addCommand(cmd);
                    flatController.removeHead();
                    break;

                case "history":
                    addCommand(cmd);
                    manager.history();
                    break;

                case "filter_balcony":
                    addCommand(cmd);
                    flatController.filterBalcony();
                    break;

                case "print_ascending":
                    addCommand(cmd);
                    flatController.printAscending();
                    break;

                case "write":
                    addCommand(cmd);
                    flatController.writeData();
                    break;

                case "read":
                    addCommand(cmd);
                    flatController.writeData();
                    break;

                default:
                    System.err.println("Unacceptable input!");

            }
        } while (loopIsTrue);

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
                        "write: write the Data of the Flats into a file.\n" +
                        "read: get the list of flats from file"
        );
    }

    //startInfoCommand
    public void startInfoCommand() {
        //Roman
        System.out.println("This FLAT MANAGER was initialized on " + this.date + ".");
        System.out.println("At the moment, the FLAT MANAGER has " + flats.size() + " of flats saved.");
        if (flats.size() < 10)
            System.out.println("Hardly impressive - but there is room for improvement");
        if (flats.size() >= 10)
            System.out.println("That's a lot of flats!");
        System.out.println("FLAT MANAGER is the result of collective effort by Team 1, Cohort 40_2 of AIT TR course.");
        System.out.println("- Sergej Schmidt");
        System.out.println("- Eugeny Davydov");
        System.out.println("- Roman Sheludko");
        System.out.println("If you have any suggestions and complaints, please let us know!");
        System.out.println("Our email is: we-dont-care-get-lost@gmail.com!");
        System.out.println("We eagerly await your feedback!");
    }

    //Switch - Case проверка команд




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