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
        String cmd = scanner.nextLine().toLowerCase();

        if (cmd.equals("add")) {
            Flat flat = new Flat();
            flatController.add(flat);
        }
    }

    //Switch - Case проверка команд


}