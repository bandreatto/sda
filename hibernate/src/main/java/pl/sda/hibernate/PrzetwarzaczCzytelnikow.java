package pl.sda.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.sda.hibernate.model.Czytelnik;

@Slf4j
public class PrzetwarzaczCzytelnikow {

    private static final SDASessionFactory SDA_SESSION_FACTORY
            = new SDASessionFactory();

    public void wypiszCzytelnika(Long id) {
//        try (SessionFactory sessionFactory = SDA_SESSION_FACTORY.getSessionFactory()) {
//            try (Session session = sessionFactory.openSession()) {
//
//            }
//        }

        try (SessionFactory sessionFactory = SDA_SESSION_FACTORY.getSessionFactory();
             Session session = sessionFactory.openSession()) {
//            Czytelnik czytelnik = session.load(Czytelnik.class, id);
            Czytelnik czytelnik = session.get(Czytelnik.class, id);
            log.info(czytelnik.toString());
        }
    }

    public static void main(String[] args) {
        PrzetwarzaczCzytelnikow przetwarzaczCzytelnikow
                = new PrzetwarzaczCzytelnikow();
        przetwarzaczCzytelnikow.wypiszCzytelnika(2L);
    }
}
