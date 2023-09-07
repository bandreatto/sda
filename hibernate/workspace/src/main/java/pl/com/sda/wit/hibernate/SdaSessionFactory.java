package pl.com.sda.wit.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.com.sda.wit.hibernate.model.Book;
import pl.com.sda.wit.hibernate.model.Category;
import pl.com.sda.wit.hibernate.model.Librarian;
import pl.com.sda.wit.hibernate.model.Reader;

@Slf4j
class SdaSessionFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            createSessionFactory();
        }

        return sessionFactory;
    }

    private static void createSessionFactory() {
        try {
            sessionFactory = new Configuration()
                    .addAnnotatedClass(Reader.class)
                    .addAnnotatedClass(Librarian.class)
                    .addAnnotatedClass(Book.class)
                    .addAnnotatedClass(Category.class)
                    .configure()
                    .buildSessionFactory();
        } catch (Exception exception) {
            log.error("Failed to create SessionFactory!", exception);
            throw new ExceptionInInitializerError(exception);
        }
    }
}
