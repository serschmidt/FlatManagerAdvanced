import controllers.FlatController;
import views.CLIView;


public class Main {
    public static void main(String[] args) {

        String fileName = "src/flats.csv";
//        if (args != null) {
//            fileName = args[0];
//        }
        /*
        if (args.length == 0) {
            System.out.println("You didn't give the path to the file!");
            return;
        }

         */

        CLIView view = new CLIView();
//        do {
//            try {
                view.startCommunication(fileName);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        } while(true);
     //   FlatController.read(fileName);

        //Старт программы
                //вызов методов для различных операций
        //чтение файла и загрузка данных в List

        //Вызов ввода пользователя: Имя
        //вызов приветствия

        //Цикл
        //вызов командной строки тоесть CLI
        //проверка на "Exit" для выхода


    }
}
