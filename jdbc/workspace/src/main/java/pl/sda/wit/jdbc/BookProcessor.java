package pl.sda.wit.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.time.LocalDate;
import java.time.Month;

@Slf4j
class BookProcessor {

    private static final String UPDATE_BOOK_PRICE_QUERY =
            "UPDATE BOOK SET PRICE = 0.5 * PRICE WHERE FORMAT = 'HARDCOVER'";
    private static final String READ_BOOKS_TEMPLATE_QUERY =
            "SELECT * FROM BOOK WHERE FORMAT = ? AND PUBLICATION_DATE <= ?";

    public void updateBookPrice() {
        try (Connection connection = JDBCConnectionProvider.getConnectionBasedOnProperties()) {
            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate(UPDATE_BOOK_PRICE_QUERY);
            log.info("Number of affected rows: {}", affectedRows);
        } catch (SQLException e) {
            log.error("Exception occurred during establishing connection...");
//            throw new RuntimeException(e);
        }
    }

    public double getTotalPrice(String format, Date publicationDate) {
        double totalPrice = 0;
        try (Connection connection = JDBCConnectionProvider.getConnectionBasedOnProperties()) {
            PreparedStatement preparedStatement = connection.prepareStatement(READ_BOOKS_TEMPLATE_QUERY);
            preparedStatement.setString(1, format);
            preparedStatement.setDate(2, publicationDate);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                double price = resultSet.getDouble(5);
                // resultSet.wasNull()
                totalPrice += price;
            }
        } catch (SQLException e) {
            log.error("Exception occurred during establishing connection...", e);
        }

        return totalPrice;
    }

    public static void main(String[] args) {
        BookProcessor bookProcessor = new BookProcessor();
//        bookProcessor.updateBookPrice();

        // Pierwszy przypadek - zestaw parametrów taki jak w zadaniu
//        LocalDate localDate = LocalDate.of(2006, Month.DECEMBER, 31);
//        Date publicationDate = Date.valueOf(localDate);
//        double totalPrice = bookProcessor.getTotalPrice("Paperback", publicationDate);

        // Drugi przypadek
        LocalDate localDate = LocalDate.of(2009, Month.MARCH, 5);
        Date publicationDate = Date.valueOf(localDate);
        double totalPrice = bookProcessor.getTotalPrice("Hardcover", publicationDate);

        log.info("Total price: {}", totalPrice);
    }
}
