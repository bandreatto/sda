package pl.sda.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sda.hibernate.model.Kategoria;

import java.io.Serializable;

@Slf4j
public class SerwisKategorii {

    public void dodajLubAktualizujKategorie(Long id, String nazwa) {
        try (SessionFactory sessionFactory = new SDASessionFactory().getSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Kategoria kategoria = session.get(Kategoria.class, id);
            kategoria.setNazwa(nazwa);

            session.saveOrUpdate(kategoria);
            log.info("done ;-)");
            transaction.commit();;
        }
    }

    public void dodajKategorie(String nazwa) {
        try (SessionFactory sessionFactory = new SDASessionFactory().getSessionFactory();
             Session session = sessionFactory.openSession()) {
//            Transaction transaction = session.beginTransaction();
            Kategoria kategoria = new Kategoria();
            kategoria.setNazwa(nazwa);

            Serializable id = session.save(kategoria);

            log.info("Saved new category ;-)");
//            transaction.rollback();
        }
    }

    public static void main(String[] args) {
        SerwisKategorii serwisKategorii = new SerwisKategorii();
        serwisKategorii.dodajKategorie("Nowa kategoria");
//        serwisKategorii.dodajLubAktualizujKategorie(7L, "Nowa kategoria - upd");
    }
}
