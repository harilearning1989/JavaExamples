package com.oracle;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    public static Connection getConnection() {

        String resourceName = "db.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();

        Connection con = null;
        try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            props.load(resourceStream);

            Class.forName(props.getProperty("DB_DRIVER_CLASS"));

            con = DriverManager.getConnection(props.getProperty("DB_URL"),
                    props.getProperty("DB_USERNAME"),
                    props.getProperty("DB_PASSWORD"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}