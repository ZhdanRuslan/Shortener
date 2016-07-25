package Shortener;

import Shortener.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ruslan on 19.07.16.
 */
public class Solution
{
    public static Set<Long> getIds(Shortener shortener, Set<String> strings)
    {
        Set<Long> idStorage = new HashSet();

        for (String s : strings)
        {
            idStorage.add(shortener.getId(s));
        }
        return idStorage;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
    {
        Set<String> stringStorage = new HashSet<>();
        for (Long s : keys)
        {
            stringStorage.add(shortener.getString(s));
        }
        return stringStorage;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber)
    {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> testSetOfStr = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++)
            testSetOfStr.add(Helper.generateRandomString());

        Shortener shortener = new Shortener(strategy);


        Set<Long> setOfIds;

        Date startTime1 = new Date();
        setOfIds = getIds(shortener, testSetOfStr);
        Date stopTime1 = new Date();

        long msDelayForIds = stopTime1.getTime() - startTime1.getTime();
        Helper.printMessage(Long.toString(msDelayForIds));

        Set<String> setOfStr;

        Date startTime2 = new Date();
        setOfStr = getStrings(shortener, setOfIds);
        Date stopTime2 = new Date();

        long msDelay2 = stopTime2.getTime() - startTime2.getTime();
        Helper.printMessage(Long.toString(msDelay2));

        if (testSetOfStr.equals(setOfStr)) {
            Helper.printMessage("Тест пройден. ");
        } else {
            Helper.printMessage("Тест не пройден. ");
        }
    }

    public static void main(String[] args)
    {
        StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 10000);
        StorageStrategy strategy1 = new HashMapStorageStrategy();
        testStrategy(strategy1, 1000);
        StorageStrategy strategy2 = new HashMapStorageStrategy();
        testStrategy(strategy2, 5000);
        OurHashBiMapStorageStrategy strategy3 = new OurHashBiMapStorageStrategy();
        testStrategy(strategy3, 7000);
        HashBiMapStorageStrategy strategy4 = new HashBiMapStorageStrategy();
        testStrategy(strategy4, 7500);
        DualHashBidiMapStorageStrategy strategy5 = new DualHashBidiMapStorageStrategy();
        testStrategy(strategy5, 5500);
    }
}
