package Shortener.strategies;

import java.io.Serializable;

/**
 * Created by ruslan on 20.07.16.
 */
public class Entry implements Serializable
{
    final Long key;
    String value;
    final int hash;
    Entry next;

    public Entry(int hash, Long key, String value, Entry next)
    {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Long getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }

    @Override
    public int hashCode()
    {
        return (int) (key % hash);
    }

    @Override
    public String toString()
    {
        return key + " = " + value;
    }
}
