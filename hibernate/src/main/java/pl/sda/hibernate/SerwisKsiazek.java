package pl.sda.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

@Slf4j
public class SerwisKsiazek {

    private static final SessionFactory SESSION_FACTORY
            = new SDASessionFactory().getSessionFactory();

    void wypiszOpisKsiazek(String nazwaKategorii) {
        try (Session session = SESSION_FACTORY.openSession()) {
            // Pobranie opisu książek na podstawie parametryzowanego zapytania HQL.
            Query<String> query = session.createQuery(
                    "SELECT k.opis FROM Ksiazka k JOIN k.kategoria kat WHERE kat.nazwa = :nazwa",
                    String.class);
            List<String> opisyKsiazek = query
                    .setParameter("nazwa", nazwaKategorii)
                    .getResultList();
            opisyKsiazek.forEach(opisKsiazki -> log.info("Opis ksiazki: {}", opisKsiazki));
        }
    }

    public static void main(String[] args) {
        SerwisKsiazek serwisKsiazek = new SerwisKsiazek();
        serwisKsiazek.wypiszOpisKsiazek("PROGRAMOWANIE");
    }
}
