package model.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BeanReader {

    private static BeanReader beanReader;

    private BeanReader() {
    }

    public static BeanReader getInstance() {
        if (beanReader == null) {
            beanReader = new BeanReader();
        }
        return beanReader;
    }
    
    public Object read(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream  fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return ois.readObject();
    }
    

}
