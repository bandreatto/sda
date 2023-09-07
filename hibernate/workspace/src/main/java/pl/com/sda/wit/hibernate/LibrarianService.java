package pl.com.sda.wit.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.com.sda.wit.hibernate.model.Librarian;

@Slf4j
class LibrarianService {

    private static final SessionFactory sessionFactory =
            SdaSessionFactory.getSessionFactory();

    private void add(String login, String password) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Librarian librarian = new Librarian();
            librarian.setLogin(login);
            librarian.setPassword(password);

            // zapisywanie (utrwalanie) obiektu
            session.persist(librarian);
            transaction.commit();
        }
    }

    private void update(Long id, String newLogin, String newPassword) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            // todo
            Librarian librarian = new Librarian();
            librarian.setId(id);
            librarian.setLogin(newLogin);
            librarian.setPassword(newPassword);

            // Metoda persist nie zadziała w tym przypadku dla aktualizacji
//            session.persist(librarian);
            // Wykorzystanie metody merge do aktualizacji
            session.merge(librarian);
            transaction.commit();
        }
    }

    private void updateManaged(Long id, String newLogin, String newPassword) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            // Utwórzmy pusty obiekt Librarian (wykorzystując konstruktor bezparametrowy)
            Librarian librarian = new Librarian();
            session.load(librarian, id); // odczytujemy zawartość rekordu o identyfikatorze id
            // i zapisujemy do obiektu librarian

            // Dooknujemy modyfikacji pól obiektu, który został uprzednio
            // odczytany metodą load
            librarian.setLogin(newLogin);
            librarian.setPassword(newPassword);

            transaction.commit();
        }
    }

    public static void main(String[] args) {
        LibrarianService service = new LibrarianService();
//        service.add("libr_login", "libr_password");
//        service.update(2L, "new_libr_login", "new_libr_password");
        service.updateManaged(2L, "extra_libro", "libro_password");
    }
}
