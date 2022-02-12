package pl.sda.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class CustomerProcessor {

//    private static final String SELECT_CUSTOMERS_QUERY = "SELECT * FROM CUSTOMER ORDER BY FIRST_NAME";
    private static final String SELECT_CUSTOMERS_QUERY = "SELECT * FROM CUSTOMER";

    public List<Customer> getCustomers() throws SQLException {
        Connection connection = JDBCConnectionProvider.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_CUSTOMERS_QUERY);

        List<Customer> customers = new ArrayList<>();

        while (resultSet.next()) {
            log.debug("Got record...");
            int customerId = resultSet.getInt("customer_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("e_mail");
            String phone = resultSet.getString("phone");
            Date createdAt = resultSet.getDate("created_at");

            Customer customer = new Customer((long) customerId, firstName, lastName, email, phone, createdAt);
            customers.add(customer);
        }

        return customers;
    }

    public void printCustomers(List<Customer> customers) {
//        customers.forEach(consumer -> log.info(consumer.toString()));
        customers.stream()
                .sorted(Comparator.comparing(Customer::getFirstName))
                .forEach(consumer -> log.info(consumer.toString()));
    }

    public static void main(String[] args) throws SQLException {
        CustomerProcessor customerProcessor = new CustomerProcessor();
        List<Customer> customers = customerProcessor.getCustomers();
        customerProcessor.printCustomers(customers);
//        log.info(customers.toString());
    }
}
