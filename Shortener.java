package Shortener;

import Shortener.strategies.StorageStrategy;

/**
 * Created by Ruslan Zhdan on 14.07.2016.
 */
public class Shortener
{

    private Long lastId = 0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy)
    {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string)
    {
            if (storageStrategy.containsValue(string))
                return storageStrategy.getKey(string);
            else
            {
                lastId++;
                storageStrategy.put(lastId, string);
                return lastId;
            }
    }

    public synchronized String getString(Long id)
    {
            if (storageStrategy.containsKey(id))
            return storageStrategy.getValue(id);
            else
                return null;
    }
}
