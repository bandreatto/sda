package pl.sda.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class AdminProcessor {

    private static final String FIND_ADMIN_TEMPLATE_QUERY
            = "SELECT * FROM ADMINS WHERE LOGIN = ? AND PASSWORD = ?";

    private static final String FIND_ADMIN_QUERY
            = "SELECT * FROM ADMINS WHERE LOGIN = '%s' AND PASSWORD = '%s'";

     public void printAdminOnPreparedStatement(String login, String password) throws SQLException {
         try (Connection connection = JDBCConnectionProvider.getConnection()) {
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ADMIN_TEMPLATE_QUERY);
             preparedStatement.setString(1, login);
             preparedStatement.setString(2, password);

             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()) {
                 int id = resultSet.getInt(1);
                 String actualLogin = resultSet.getString(2);
                 String actualPassword = resultSet.getString(3);

                 log.info("id = {}, login = {}, password = {}", id, actualLogin, actualPassword);
             }
         }
     }

    public void printAdmin(String login, String password) throws SQLException {
        String query = String.format(FIND_ADMIN_QUERY, login, password);
        log.info("query: " + query);

//        String actualQuery = "SELECT * FROM ADMINS WHERE LOGIN = '" + login + "' AND PASSWORD = '"
//                + password + "'";

        try (Connection connection = JDBCConnectionProvider.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String actualLogin = resultSet.getString(2);
                String actualPassword = resultSet.getString(3);

                log.info("id = {}, login = {}, password = {}", id, actualLogin, actualPassword);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        AdminProcessor adminProcessor = new AdminProcessor();

//        adminProcessor.printAdmin("user_2", "password_2' OR '1' = '1");
        adminProcessor.printAdminOnPreparedStatement("user_2", "password_2' OR '1' = '1");
    }
}
