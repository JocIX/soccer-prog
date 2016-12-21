package hu.icontest.soccer.prog.dao;

import hu.icontest.soccer.prog.MyUI;
import hu.icontest.soccer.prog.model.Player;
import hu.icontest.soccer.prog.model.Team;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 * @author developer
 * @since Dec 01, 2016
 */
public class PlayerDao {

    public static void addPlayer(Player player, String team) {
        EntityManagerFactory emf = MyUI.emf;
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Team _team = em.createQuery("select t from teams as t where t.name = :team", Team.class)
                .setParameter("team", team)
                .getSingleResult();
        player.setCurrentTeam(_team);
        em.persist(player);
        em.getTransaction().commit();

        em.close();
    }

    public static List<Player> readPlayers() {
        EntityManagerFactory emf = MyUI.emf;
        EntityManager em = emf.createEntityManager();

        return em.createQuery("select p from players as p left join fetch p.currentTeam", Player.class)
                .getResultList();
    }

    public static Player getPlayer(Long id) {

        try {
            EntityManagerFactory emf = MyUI.emf;
            EntityManager em = emf.createEntityManager();
            return em
                    .createQuery("select p from players as p join fetch p.currentTeam where p.id =:id", Player.class)
                    .setParameter("id", id)
                    .getSingleResult();
            // em.close();
        } catch (NoResultException e) {
            return null;
        }
    }

    public static void removePlayer(Player player) {
        List<Player> lista = readPlayers();

        EntityManagerFactory emf = MyUI.emf;
        EntityManager em = emf.createEntityManager();

        Player temp = null;
        for (Player p : lista) {
            if (p.getLastName().equals(player.getLastName())) {
                temp = p;
                break;
            }

        }
        em.getTransaction().begin();

        Player bla = em.merge(temp);
        em.remove(bla);
        em.getTransaction().commit();

        em.close();
    }

}
