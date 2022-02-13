package pl.sda.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@Slf4j
public class SDASessionFactory {

    private static SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry standardRegistry
                    = new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata = new MetadataSources(standardRegistry)
                    .getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }

        return sessionFactory;
    }

    public static void main(String[] args) {
        SDASessionFactory sdaSessionFactory = new SDASessionFactory();
        SessionFactory sessionFactory = sdaSessionFactory.getSessionFactory();
        log.info("Got sesssion Factory...");
        try (Session session = sessionFactory.openSession()) {
            log.info("Got session...");
        }
    }
}
