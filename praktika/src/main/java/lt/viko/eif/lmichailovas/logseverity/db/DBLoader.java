/**
 * The DBLoader class is responsible for loading data into the database and retrieving data from the database.
 * It contains methods to load user accounts with associated logs into the database and to retrieve the loaded data from the database.
 */
package lt.viko.eif.lmichailovas.logseverity.db;

import lt.viko.eif.lmichailovas.logseverity.model.*;
import lt.viko.eif.lmichailovas.logseverity.util.JaxbUtil;
import lt.viko.eif.lmichailovas.logseverity.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class DBLoader {
    static {
        User worker1 = new User("firstName1", "lastName1", "code1");
        User worker2 = new User("firstName3", "lastName3", "code3");
        Account account1 = new Account("UserName1", "Password1");
        Log log1 = new Log("lognameTEST", "logdiscription1", 1);
        Log log2 = new Log("logname2", "logdiscription2", 2);
        LogSource logsource1 = new LogSource("fortigate", "8.8.8.8");
        LogIp logip1 = new LogIp("8.8.4.4");

        worker1.setAccount(account1);
        account1.getLogList().add(log1);
        account1.getLogList().add(log2);
        log1.setLogsource(logsource1);
        log1.setLogip(logip1);
        JaxbUtil.convertToXML(worker1);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(worker1);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Loads the account logs into the database and retrieves them.
     */
    public static void loadAccountLogs() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Account> accountLogs = session.createQuery("from Account", Account.class).list();
            accountLogs.forEach(accountLog -> System.out.println(accountLog));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the workers into the database and retrieves them.
     */
    public static void loadWorker() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<User> workers = session.createQuery("from User", User.class).list();
            workers.forEach(worker -> System.out.println(worker));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}