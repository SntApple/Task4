package edu.serviceSender;

import org.slf4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;;
import java.sql.SQLException;
import java.util.Properties;

import static org.slf4j.LoggerFactory.getLogger;


public class DataSourceFactory {
    private static final Logger LOGGER = getLogger(DataSourceFactory.class);
    private static final String RESOURCE_PATH = "";
    private static Connection conn = null;

    private DataSourceFactory() {
    }

    public static Connection getConnection() {
        if (conn == null) {
            try (FileInputStream fileInputStream = new FileInputStream(RESOURCE_PATH)) {
                Properties prop = new Properties();
                prop.load(fileInputStream);
                Class.forName(prop.getProperty("driver"));
                conn = DriverManager.getConnection(prop.getProperty("database.url"),
                        prop.getProperty("database.username"), prop.getProperty("database.password"));
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            } catch (FileNotFoundException e) {
                LOGGER.error("FileNotFoundException", e);
            } catch (IOException e) {
                LOGGER.error("IOException", e);
            } catch (ClassNotFoundException e) {
                LOGGER.error("ClassNotFoundException", e);
            }
        }
        return conn;
    }
}
