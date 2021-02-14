package com.devxschool.apiframework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {
    static Properties properties;
    static String file_path = "src/test/resources/properties/configuration.properties";

    static {
        try (FileInputStream fis = new FileInputStream(file_path)) {
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
