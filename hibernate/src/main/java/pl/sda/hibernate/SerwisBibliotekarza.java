package pl.sda.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sda.hibernate.model.Bibliotekarz;

import java.io.Serializable;

@Slf4j
public class SerwisBibliotekarza {

    private static final SessionFactory SESSION_FACTORY
            = new SDASessionFactory().getSessionFactory();

    void wypisz(Long id) {
        try (Session session = SESSION_FACTORY.openSession()) {
            // Pobranie bibliotekarzaz bazy danych oraz wypisanie informacji na konsoli
            // przy pomocy zdefiniowanego loggera.
            Bibliotekarz bibliotekarz = session.get(Bibliotekarz.class, id);
            log.info("bibliotekarz: {}", bibliotekarz);
        }
    }

    void dodaj(String login, String haslo) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction transaction = session.beginTransaction();
            Bibliotekarz bibliotekarz = new Bibliotekarz();
            bibliotekarz.setLogin(login);
            bibliotekarz.setHaslo(haslo);

            // Zapisanie encji do bazy danych.
            // Metoda persis wymaga jawnego deklarowania transakcji.
            // Metoda save() nie wymaga jawnego deklarowania transakcji.
            // Dodatkowo, metoda save() zwraca identyfikator encji - uzyskany w ramach
            // operacji zapisu do bazy danych.
            session.persist(bibliotekarz);
            log.info("Saved to db bibliotekarz");
            transaction.commit();
        }
    }

    void aktualizuj(Long id, String haslo) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction transaction = session.beginTransaction();

            Bibliotekarz bibliotekarz = session.get(Bibliotekarz.class, id);
            bibliotekarz.setHaslo(haslo);

            // W przypadku obiektów zarządzonych przez Hibernate'a,
            // nie ma potrzeby jawnego wywoływania metody update
            // celem utrwalenia zmian w bazie danych.
            // Hibernate wykona samoczynnie aktualizacje w momencie
            // zatwierdzania transakcji.

            // Usunięcie wszystkich obiektó zarządzanych przez Hibernate'a.
//            session.clear();

            transaction.commit();
        }
    }

    void usun(Long id) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction transaction = session.beginTransaction();
            Bibliotekarz bibliotekarz = session.load(Bibliotekarz.class, id);

            // Encję mozemy usunąć posługując się obiektem zarządzanym
            // (pobranym z bazy danych przy pomocy metody get lub load)
            // lub też obiektem samodzielnie zainicjalizowanym z uzupełnionym identyfikatorem.

//            Bibliotekarz bibliotekarz = new Bibliotekarz();
//            bibliotekarz.setId(id);

            session.delete(bibliotekarz); // lub wykorzystanie metody remove(Object)

            log.info("Usunieto bibliotekarza");
            transaction.commit();
        }
    }

    public static void main(String[] args) {
        SerwisBibliotekarza serwisBibliotekarza = new SerwisBibliotekarza();
//        serwisBibliotekarza.wypisz(1L);
//        serwisBibliotekarza.dodaj("loginXY1", "hasloXY1");
//        serwisBibliotekarza.aktualizuj(4L, "hasloWZ3");
        serwisBibliotekarza.usun(6L);

        SESSION_FACTORY.close();
    }
}
