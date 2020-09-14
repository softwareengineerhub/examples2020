package com.app04.ch01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class AbstractXmlDataProcessor implements DataProcessor {
    protected File file;

    public AbstractXmlDataProcessor(File file) {
        this.file = file;
    }

    @Override
    public void write(Car car)  {
        try {
            URL url = getClass().getResource("/app04/ch01/car-template.xml");
            Path path = Paths.get(url.toURI());
            byte[] data = Files.readAllBytes(path);
            String content = new String(data);
            String text = String.format(content, car.getName(), car.getAge());

            PrintStream old = System.out;

            PrintStream ps = new PrintStream(new FileOutputStream(file));
            System.setOut(ps);
            System.out.println(text);

            System.setOut(old);
            System.out.println("sgsgsgdfgd");
        } catch(Exception ex){
            throw  new RuntimeException(ex);
        }
    }

}
