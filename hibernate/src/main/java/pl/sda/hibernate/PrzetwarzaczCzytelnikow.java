package pl.sda.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.sda.hibernate.model.Czytelnik;

@Slf4j
public class PrzetwarzaczCzytelnikow {

    private static final SessionFactory SESSION_FACTORY
            = new SDASessionFactory().getSessionFactory();

    public void wypiszCzytelnika(Long id) {
        try (Session session = SESSION_FACTORY.openSession()) {
            // Porównanie metod load oraz get (lazy-loading oraz eager-loading)
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
