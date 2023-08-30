package pl.sda.wit.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
class DataSourceProvider {

    private static final String DB_URL_PROPERTY_KEY = "pl.sda.jdbc.db.url";
    private static final String DB_USERNAME_PROPERTY_KEY = "pl.sda.jdbc.db.username";
    private static final String DB_PASSWORD_PROPERTY_KEY = "pl.sda.jdbc.db.password";

    public static DataSource getDataSource() throws IOException {
        MysqlDataSource dataSource = new MysqlDataSource();
        Properties properties = loadProperties();

        dataSource.setUrl(properties.getProperty(DB_URL_PROPERTY_KEY));
        dataSource.setUser(properties.getProperty(DB_USERNAME_PROPERTY_KEY));
        dataSource.setPassword(properties.getProperty(DB_PASSWORD_PROPERTY_KEY));

        return dataSource;
    }

    private static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        // Zakomentowano celem demonstracji odczytu właściwości z pliku .properties
//        properties.setProperty(DB_URL_PROPERTY_KEY,
//                "jdbc:mysql://localhost:3306/sda_jdbc?serverTimezone=UTC");
//        properties.setProperty(DB_USERNAME_PROPERTY_KEY, "root");
//        properties.setProperty(DB_PASSWORD_PROPERTY_KEY, "admin");

        // blok try-with-resources, java zamyka zasób (strumień) samodzielnie
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream("db.properties")) {
            properties.load(inputStream);
        }
//        inputStream.close();

        return properties;
    }

    public static void main(String[] args) throws SQLException, IOException {
        DataSource dataSource = getDataSource();
        Connection connection = dataSource.getConnection();
        String catalog = connection.getCatalog();
        log.info("catalog: " + catalog);
    }
}
