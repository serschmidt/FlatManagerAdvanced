package views;


import models.Flat;
import controllers.FlatController;
import controllers.IFlatController;

import java.util.Scanner;
public class CLIView {
    private IFlatController flatController;

    public CLIView(){
        flatController = new FlatController();
    }

    public void startCommunication() {

        Scanner
        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine();

        if (cmd.equals("add")) {
            Flat flat = new Flat();
            flatController.add(flat);
        }
    }
}