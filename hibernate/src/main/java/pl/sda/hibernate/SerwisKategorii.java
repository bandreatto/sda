package pl.sda.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sda.hibernate.model.Kategoria;

import java.io.Serializable;

@Slf4j
public class SerwisKategorii {

    private static final SessionFactory SESSION_FACTORY
            = new SDASessionFactory().getSessionFactory();

    public void dodajLubAktualizujKategorie(Long id, String nazwa) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction transaction = session.beginTransaction();
            Kategoria kategoria = session.get(Kategoria.class, id);
            kategoria.setNazwa(nazwa);

            // Zapis / aktualizacja nowej kategorii w bazie danych.
            session.saveOrUpdate(kategoria);
            log.info("saved / updated");
            transaction.commit();;
        }
    }

    public void dodajKategorie(String nazwa) {
        try (Session session = SESSION_FACTORY.openSession()) {
//            Transaction transaction = session.beginTransaction();
            Kategoria kategoria = new Kategoria();
            kategoria.setNazwa(nazwa);

            // Zapisanie nowej kategorii w bazie danych.
            // Metoda save (zwracająca idetyfikator encji, nie wymaga
            // jawnego deklarowania transakcji).
            Serializable id = session.save(kategoria);

            log.info("Saved new category ;-)");
//            transaction.rollback();
        }
    }

    public void wypiszKategorie(Long id) {
        try (Session session = SESSION_FACTORY.openSession()) {
            // Pobranie kategorii na podstawie identyfikatora.
            Kategoria kategoria = session.get(Kategoria.class, id);
            log.info("kategoria: {}", kategoria);
        }
    }

    public static void main(String[] args) {
//        log.info("I'm in main method");

        SerwisKategorii serwisKategorii = new SerwisKategorii();
//        serwisKategorii.dodajKategorie("Nowa kategoria");
//        serwisKategorii.dodajLubAktualizujKategorie(7L, "Nowa kategoria - upd");

      serwisKategorii.wypiszKategorie(3L);
    }
}
