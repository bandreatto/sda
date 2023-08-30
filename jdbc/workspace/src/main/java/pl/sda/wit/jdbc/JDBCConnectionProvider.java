package pl.sda.wit.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
class JDBCConnectionProvider {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/sda_jdbc?serverTimezone=UTC";

    public static Connection getConnectionBasedOnProperties() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root"); // nazwa użytkownika: root
        properties.setProperty("password", "admin"); // hasło użytkownika: admin

        return DriverManager.getConnection(DB_URL, properties);
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnectionBasedOnProperties();
        String catalog = connection.getCatalog();
//        System.out.println("Catalog = " + catalog);
        log.info("Catalog = " + catalog);
    }
}
