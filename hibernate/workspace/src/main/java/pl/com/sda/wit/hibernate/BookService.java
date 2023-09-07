package pl.com.sda.wit.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import pl.com.sda.wit.hibernate.model.Book;

import java.util.List;

@Slf4j
class BookService {

    private static final SessionFactory sessionFactory =
            SdaSessionFactory.getSessionFactory();

    private void printBook(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Book book = session.get(Book.class, id);
            log.info("Book: {}", book);
        }
    }

    private void printBookTitles(String categoryName) {
        try (Session session = sessionFactory.openSession()) {
            // Zapytanie parametryzowane, pobiramy tytuły książek, zapytanie HQL
            // (tożsame z PreparedStatement z JDBC)
            Query<String> query = session.createQuery("SELECT b.title FROM Book b JOIN b.category c " +
                    "WHERE c.name = :name", String.class);
            // Ustawiamy wartość parametru i pobieramey wyniki
            List<String> bookTitles = query.setParameter("name", categoryName)
                    .getResultList();

            // Wypisujemy wyniki na konsoli
            bookTitles.forEach(bookTitle -> log.info(bookTitle));
        }
    }

    public static void main(String[] args) {
        BookService bookService = new BookService();
//        bookService.printBook(9L);
        bookService.printBookTitles("PROGRAMOWANIE");
    }
}
