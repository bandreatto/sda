package pl.sda.wit.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
class CustomerProcessor {

    // Zapytanie select
    private static final String SELECT_ALL_CUSTOMERS_QUERY
            = "SELECT * FROM CUSTOMER";

    List<Customer> getCustomers() throws SQLException {
        // 1. Pobieramy połączenie
        try (Connection connection = JDBCConnectionProvider.getConnectionBasedOnProperties()) {
            // 2. Tworzymy obiekt Statement
            Statement statement = connection.createStatement();
            // 3. Wykonujemy zapytanie (select)
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CUSTOMERS_QUERY);

            List<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                long customerId = resultSet.getLong("CUSTOMER_ID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                String eMail = resultSet.getString("E_MAIL");
                String phone = resultSet.getString("PHONE");
                Date createdAt = resultSet.getDate("CREATED_AT");

                Customer customer = new Customer(customerId, firstName, lastName, eMail, phone, createdAt);
                customers.add(customer);
            }

            return customers;
        }
    }

    public static void main(String[] args) throws SQLException {
        CustomerProcessor customerProcessor = new CustomerProcessor();
        List<Customer> customers = customerProcessor.getCustomers();
        customers.forEach(customer -> {
            log.info(customer.toString());
        });
    }
}

