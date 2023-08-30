package pl.sda.wit.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
class AdminProcessor {

    private static final String FIND_ADMIN_QUERY
            = "SELECT * FROM admins WHERE login = '%s' AND password = '%s'";
    private static final String FIND_ADMIN_TEMPLATE_QUERY
            = "SELECT *  FROM admins WHERE login = ? AND password = ?";

    void createTable() {
        try (Connection connection = JDBCConnectionProvider.getConnectionBasedOnProperties()) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE admins (" +
                    " id INT NOT NULL AUTO_INCREMENT," +
                    " login VARCHAR(50) NOT NULL," +
                    " password VARCHAR(45) NOT NULL," +
                    " PRIMARY KEY (id))");
        } catch (SQLException e) {
            // off, error, warn, info, debug, trace
            log.error("Exception occurred during establishing connection to database", e);
        }
    }

    void printAdmin(String login, String password) {
        try (Connection connection = JDBCConnectionProvider.getConnectionBasedOnProperties()) {
            Statement statement = connection.createStatement();
            String actualQuery = String.format(FIND_ADMIN_QUERY, login, password);
            log.debug("Actual query: " + actualQuery);
            ResultSet resultSet = statement.executeQuery(actualQuery);
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String actualLogin = resultSet.getString(2);
                String actualPassword = resultSet.getString(3);
                log.info("id = {}, login = {}, password = {}", id, actualLogin, actualPassword);
            }

            // Pierwsza opcja budowy zapytania
//            String sql = "SELECT * FROM admins WHERE login = '"
//                    + login + "' AND password = '" + password + "'";
            // Druga opcja budowy zapytania
//            String sql = String.format("SELECT * FROM admins WHERE login = '%s' AND password = '%s'",
//                    login, password);
        } catch (SQLException e) {
            // off, error, warn, info, debug, trace
            log.error("Exception occurred during establishing connection to database", e);
        }
    }

    void printTemplateAdmin(String login, String password) {
        try (Connection connection = JDBCConnectionProvider.getConnectionBasedOnProperties()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ADMIN_TEMPLATE_QUERY);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String actualLogin = resultSet.getString(2);
                String actualPassword = resultSet.getString(3);
                log.info("id = {}, login = {}, password = {}", id, actualLogin, actualPassword);
            }
        } catch (SQLException e) {
            log.error("Exception occurred during establishing connection to database", e);
        }
    }

    public static void main(String[] args) {
        AdminProcessor adminProcessor = new AdminProcessor();
//        adminProcessor.createTable();
        // znamy login, ale nie znamy hasła, mimo to odczytujemy rekord
//        adminProcessor.printAdmin("admin_1' -- ", "no matter");
//        adminProcessor.printTemplateAdmin("admin_1' -- ", "no matter");

        // odczytujemy całą zawartość tabeli
//        adminProcessor.printAdmin("unknown_login", "unknown_password' OR 'foo' = 'foo");
//        adminProcessor.printTemplateAdmin("unknown_login", "unknown_password' OR 'foo' = 'foo");

        adminProcessor.printTemplateAdmin("admin_1", "password_1");
    }
}

