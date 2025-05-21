package model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BeanWriter {

    public static BeanWriter beanWriter;

    private BeanWriter() {
    }

    public static synchronized BeanWriter getInstance() {
        if (beanWriter == null) {
            beanWriter = new BeanWriter();
        }
        return beanWriter;
    }

    public void write(File file, Object bean) throws FileNotFoundException, IOException {
        //  try-with-resources approach ensures automatic closing of streams and flush
        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(bean);
        }
    }
}
