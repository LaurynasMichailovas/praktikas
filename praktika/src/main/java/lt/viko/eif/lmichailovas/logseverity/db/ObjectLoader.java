/**
 * The ObjectLoader class is responsible for loading an object of a specified entity type from the database.
 * It contains a method to load an object of a given entity type based on its ID from the database.
 */
package lt.viko.eif.lmichailovas.logseverity.db;

import lt.viko.eif.lmichailovas.logseverity.util.HibernateUtil;
import org.hibernate.Session;

public class ObjectLoader {
    /**
     * Loads an object of the specified entity type from the database based on its ID.
     * @param <T> The generic type representing the entity type.
     * @param entityType The Class object representing the entity type.
     * @param entityId The ID of the entity to be loaded.
     * @return The loaded object of the specified entity type, or null if not found.
     */
    public static <T> T objectLoad(Class<T> entityType, int entityId) {
        T entity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.get(entityType, entityId);
            if (entity != null) {
                System.out.println(entity);
            } else {
                System.out.println(entityType.getSimpleName() + " with ID " + entityId + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
}