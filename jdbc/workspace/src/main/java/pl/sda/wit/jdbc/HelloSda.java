package pl.sda.wit.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

@Slf4j
class HelloSda {

    private static final String HELLO_SDA_FUNCTION_CALL_TEMPLATE
            = "{? = call hello_sda_function(?)}";

    public void callHelloSda(String name) {
        try (Connection connection = JDBCConnectionProvider.getConnectionBasedOnProperties()) {
            CallableStatement statement = connection.prepareCall(HELLO_SDA_FUNCTION_CALL_TEMPLATE);
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.setString(2, name);

            boolean executed = statement.execute();
            log.info("Executed: {}", executed);

            String message = statement.getString(1);
            log.info("Message from function: {}", message);
        } catch (SQLException e) {
            log.error("Exception occurred during helloSda function invocation!", e);
        }
    }

    public static void main(String[] args) {
        HelloSda helloSda = new HelloSda();
        helloSda.callHelloSda("Bartosz");
    }
}
