package com.example.metroapp.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SpringBootStripeProperties
{
    public static Properties springBootStripeData = loadProperties("D:/SpringBootStripeProject-master/SpringBootStripeProject-master/src/main/resources/application.properties");
    private static Properties loadProperties(String filePath) {
        Properties properties = new Properties();
        try {
            FileInputStream f = new FileInputStream(filePath);
            properties.load(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
