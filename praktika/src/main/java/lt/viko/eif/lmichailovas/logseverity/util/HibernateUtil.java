/**
 * The HibernateUtil class provides utility methods for managing Hibernate SessionFactory.
 * It initializes the SessionFactory using Hibernate configuration.
 */
package lt.viko.eif.lmichailovas.logseverity.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Builds and initializes the Hibernate SessionFactory.
     * @return The initialized SessionFactory.
     */
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retrieves the Hibernate SessionFactory.
     * @return The Hibernate SessionFactory.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}