package db;

import models.Console;
import models.Game;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBGame {


    private static Session session;
    private static Transaction transaction;

    public static List<Console> getAvailableConsoles(Console console) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Console> results = null;
        try {
            Criteria cr = session.createCriteria(Game.class);
            cr.createAlias("consoles", "console");
            cr.add(Restrictions.eq("console.id", console.getId()));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static List<Console> getAllAvailableGames(Game game1) {
    }
}




