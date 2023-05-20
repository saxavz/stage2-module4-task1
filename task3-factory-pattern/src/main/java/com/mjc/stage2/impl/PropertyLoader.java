package com.mjc.stage2.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    public static Properties loadProperties(String propertyFileName) {
        Properties props = new Properties();

        try(InputStream inputStream = PropertyLoader.class
                .getClassLoader()
                .getResourceAsStream(propertyFileName)) {
            props.load(inputStream);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return props;
    }
}
