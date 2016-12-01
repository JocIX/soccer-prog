package hu.icontest.soccer.prog.dao;

import hu.icontest.soccer.prog.model.Player;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author developer
 * @since Dec 01, 2016
 */
public class PlayerDao {

    public static void addPlayer(Player player) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soccer-prog-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(player);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

}
