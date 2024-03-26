package controllers;

public class Utils {


    public static boolean isString(String str) {
        //Проверка на пустую Строку
        str.replaceAll(" ", "");
        if (!str.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isInt(String str) {
        try {  // блок с которого все начнется тут
            // если завершится с ошибкой, то перейдет в catche блок
            Integer.valueOf(str);
            // если предыдущая строка успешно отработала, то возвращаем true
            return true;
        } catch (Exception e) {
            return false; // если попали в catch, то возращаем false
        }
    }

    public static boolean isLong(String str) {
        try {  // блок с которого все начнется тут
            // если завершится с ошибкой, то перейдет в catche блок
            Long.valueOf(str);
            // если предыдущая строка успешно отработала, то возвращаем true
            return true;
        } catch (Exception e) {
            return false; // если попали в catch, то возращаем false
        }
    }

    public static boolean isDouble(String str) {
        try {  // блок с которого все начнется тут
            // если завершится с ошибкой, то перейдет в catche блок
            Double.valueOf(str);
            // если предыдущая строка успешно отработала, то возвращаем true
            return true;
        } catch (Exception e) {
            return false; // если попали в catch, то возращаем false
        }
    }

    public static boolean isBoolean(String str) {
        try {  // блок с которого все начнется тут
            // если завершится с ошибкой, то перейдет в catche блок
            //noinspection ResultOfMethodCallIgnored
            str.toLowerCase();
            return "true".equals(str) || "false".equals(str);
            // если предыдущая строка успешно отработала, то возвращаем true
//            return true;
        } catch (Exception e) {
            return false; // если попали в catch, то возращаем false
        }
    }

    public static boolean isEnum(String str, Class<? extends Enum<?>> enumClass) {
        try {  // блок с которого все начнется тут
            // если завершится с ошибкой, то перейдет в catche блок
            enumClass.getField(str);
            // если предыдущая строка успешно отработала, то возвращаем true
            return true;
        } catch (Exception e) {
            return false; // если попали в catch, то возращаем false
        }
    }
}

//comment for new commit