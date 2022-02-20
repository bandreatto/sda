package pl.sda.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.sda.hibernate.model.Admin;

@Slf4j
public class AdminService {

    // Definicja fabryki sesji w postaci stałej statycznej.
    // Fabryka sesji nie powinna być zamykana (docelowo w aplikacji)
    // w oparciu o podejscie try-with-resource na poziomie
    // pojedynczej operacji DAO.
    private static final SessionFactory SESSION_FACTORY
            = new SDASessionFactory().getSessionFactory();

    void logAdmin(Long id) {
        // Pobranie administratora na podstawie identyfikatora.
        try (Session session = SESSION_FACTORY.openSession()) {
            Admin admin = session.get(Admin.class, id);
            log.info("admin: {}", admin);
        }
    }

    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        adminService.logAdmin(1L);
    }
}
