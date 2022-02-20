package pl.sda.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.sda.hibernate.model.Logowanie;
import pl.sda.hibernate.model.LogowanieId;

@Slf4j
public class SerwisLogowania {

    private static final SessionFactory SESSION_FACTORY
            = new SDASessionFactory().getSessionFactory();

    void wypiszDaneLogowania(LogowanieId id) {
        try (Session session = SESSION_FACTORY.openSession()) {
            // Pobranie encji Logowanie na podstawie złożonego klucza głównego
            // modelowanego w oparciu o klasę LogowanieId opatrzoną adnotacją @Embeddable.
            Logowanie logowanie = session.get(Logowanie.class, id);
            log.info("dane logowania: {}", logowanie);
        }
    }

    public static void main(String[] args) {
        SerwisLogowania serwisLogowania = new SerwisLogowania();

        LogowanieId id = new LogowanieId(1L, 5L);
        serwisLogowania.wypiszDaneLogowania(id);
    }
}
