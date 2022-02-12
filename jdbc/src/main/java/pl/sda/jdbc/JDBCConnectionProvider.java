package pl.sda.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnectionProvider {

    private static final String URL = "jdbc:mysql://localhost:3306/sda_jdbc?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(JDBCConnectionProvider.class);

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Connection getConnectionBasedOnProperties() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASSWORD);

        return DriverManager.getConnection(URL, properties);
    }

    public static Connection getConnectionBasedOnUrlParameters() throws SQLException {
        String parametrizedUrl = URL + "&user=" + USER + "&password=" + PASSWORD;
        return DriverManager.getConnection(parametrizedUrl);
    }

    public static void main(String[] args) throws SQLException {
//        Connection connection = getConnection();
//        Connection connection = getConnectionBasedOnProperties();
        Connection connection = getConnectionBasedOnUrlParameters();
        String catalog = connection.getCatalog();
        log.info("Catalog: " + catalog);
//        System.out.println("Catalog: " + catalog);
    }
}
