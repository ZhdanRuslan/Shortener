package Shortener.strategies;

import Shortener.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by ruslan on 21.07.16.
 */
public class FileBucket
{
    private Path path;

    public FileBucket()
    {
        try {
            path = Files.createTempFile("tmp", null);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize(){
        return path.toFile().length();
    }

    public void putEntry(Entry entry){
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(path.toFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(entry);
            fileOutputStream.close();
            objectOutputStream.close();
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry(){
        Entry result = null;
        if(path.toFile().length() > 0)
        {
            try
            {
                FileInputStream fileInputStream = new FileInputStream(path.toString());
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Object object = objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
                return (Entry) object;
            }
            catch (ClassNotFoundException | IOException e)
            {
                ExceptionHandler.log(e);
            }
        }
        return result;
    }

    public void remove(){
        try {
            Files.delete(path);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
