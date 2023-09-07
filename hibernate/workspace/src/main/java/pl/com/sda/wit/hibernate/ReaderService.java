package pl.com.sda.wit.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.com.sda.wit.hibernate.model.Reader;

@Slf4j
class ReaderService {

    public static void main(String[] args) {
        SessionFactory sessionFactory =
                SdaSessionFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            // 1.
            // pierwszy parametr: OBIEKT encyjny
            // drugi parametr: wartość identyfikatora (klucz główny)
            // session.load();

            // 2.
            // pierwszy parametr: KLASA (typ) encji
            // drugi parametr: wartość identyfikatora (klucz główny)
            Reader reader = session.get(Reader.class, 1L);
            log.info("Reader: " + reader);
        }
    }
}
