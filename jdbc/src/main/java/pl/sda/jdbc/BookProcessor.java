package pl.sda.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class BookProcessor {

    private static final String READ_BOOKS_TEMPLATE_QUERY
            = "SELECT * FROM BOOK WHERE FORMAT = ? AND PUBLICATION_DATE <= ?";

    private static final String READ_ALL_BOOKS_QUERY = "SELECT * FROM BOOK";

    private static final String UPDATE_PRICE_QUERY
            = "UPDATE BOOK SET PRICE = 0.5 * PRICE WHERE FORMAT = 'Hardcover'";

    private static final String ADD_BOOK_QUERY
            = "INSERT INTO BOOK VALUES('test_isbn', 'test_title', '2022-02-12', 'Hardcover', 31.15)";

    private static final String DELETE_WHITE_BOOKS_QUERY
            = "DELETE FROM BOOK WHERE TITLE LIKE 'The White%'";

    public List<Book> getBooks() throws SQLException {
        List<Book> books = new ArrayList<>();

        try (Connection connection = JDBCConnectionProvider.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_ALL_BOOKS_QUERY);
            while (resultSet.next()) {
                String isbn = resultSet.getString(1);
                String title = resultSet.getString(2);
                Date publicationDate = resultSet.getDate(3);
                String format = resultSet.getString(4);
                Double price = resultSet.getDouble(5);
                if (resultSet.wasNull()) {
                    price = null;
                }

                Book book = new Book(isbn, title, publicationDate, format, price);
                books.add(book);
            }
        }

        return books;
    }

    public void updatePrice() throws SQLException {
        try (Connection connection = JDBCConnectionProvider.getConnection()) {
            Statement statement = connection.createStatement();
            int updatedRows = statement.executeUpdate(UPDATE_PRICE_QUERY);
            log.info("Updated rows: " + updatedRows);
        }
    }

    public double getTotalPrice() {

        // todo
        return 0.0;
    }

    public void addBook() throws SQLException {
        try (Connection connection = JDBCConnectionProvider.getConnection()) {
            Statement statement = connection.createStatement();
            boolean execute = statement.execute(ADD_BOOK_QUERY);
            log.info("execute = " + execute);
        }
    }

    public void deleteWhiteBooks() throws SQLException {
        try (Connection connection = JDBCConnectionProvider.getConnection()) {
            Statement statement = connection.createStatement();
            int deletedRows = statement.executeUpdate(DELETE_WHITE_BOOKS_QUERY);
            log.info("Deleted rows: " + deletedRows);
        }
    }

    public double getTotalPrice(String format, Date publicationDate) throws SQLException {
        double totalSum = 0;

        try (Connection connection = JDBCConnectionProvider.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(READ_BOOKS_TEMPLATE_QUERY);
            preparedStatement.setString(1, format);
            preparedStatement.setDate(2, publicationDate);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                double bookPrice = resultSet.getDouble(5);
                totalSum += bookPrice;
            }
        }

        return totalSum;
    }

    public void printBooks(List<Book> books) {
        books.stream()
                .sorted(Comparator.comparing(Book::getIsbn))
                .map(Book::toString)
                .forEach(log::info);
    }

    public static void main(String[] args) throws SQLException {
        BookProcessor bookProcessor = new BookProcessor();
        List<Book> books = bookProcessor.getBooks();
        bookProcessor.printBooks(books);

//        bookProcessor.updatePrice();
//
//        log.info("");
//        books = bookProcessor.getBooks();
//        bookProcessor.printBooks(books);

//        log.info("");
//        bookProcessor.addBook();
//        books = bookProcessor.getBooks();
//        bookProcessor.printBooks(books);

//        log.info("");
//        bookProcessor.deleteWhiteBooks();;
//        books = bookProcessor.getBooks();
//        bookProcessor.printBooks(books);

        LocalDate localDate = LocalDate.of(2006, Month.DECEMBER, 31);
        Date publicationDate = java.sql.Date.valueOf(localDate);
        double totalPrice = bookProcessor.getTotalPrice("Paperback", publicationDate);
        log.info("Total price = " + totalPrice);
    }
}
