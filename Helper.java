package Shortener;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by ruslan on 19.07.16.
 */
public class Helper
{
    public static String generateRandomString()
    {
        SecureRandom random = new SecureRandom();
        return new BigInteger(100, random).toString(32);
    }


    public static void printMessage(String message)
    {
        System.out.println(message);
    }

}
