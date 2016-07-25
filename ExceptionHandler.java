package Shortener;

/**
 * Created by ruslan on 19.07.16.
 */
public class ExceptionHandler
{
    public static void log(Exception e){
        Helper.printMessage(e.getMessage());
    }
}
