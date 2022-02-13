package pl.sda.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

@Slf4j
public class HelloSda {

    private static final String CALL_SDA_FUNCTION_QUERY
            = "{? = call hello_sda_function(?)}";

    public void invokeProcedure(String name) throws SQLException {
        try (Connection connection = JDBCConnectionProvider.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall(CALL_SDA_FUNCTION_QUERY);
            callableStatement.setString(2, name);
            callableStatement.registerOutParameter(1, Types.VARCHAR);

            callableStatement.execute();

            String result = callableStatement.getString(1);
            log.info("result = {}", result);
        }
    }

    public static void main(String[] args) throws SQLException {
        HelloSda helloSda = new HelloSda();
        helloSda.invokeProcedure("Bartosz");
    }
}
