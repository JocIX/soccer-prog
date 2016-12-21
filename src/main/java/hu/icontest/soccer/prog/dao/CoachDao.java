/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.icontest.soccer.prog.dao;

import com.vaadin.ui.Component;
import hu.icontest.soccer.prog.MyUI;
import hu.icontest.soccer.prog.model.Coach;
import hu.icontest.soccer.prog.model.Player;
import hu.icontest.soccer.prog.model.Team;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author developer
 * @since Dec 01, 2016
 */
public class CoachDao {

    public static void addCoach(Coach coach, String team) {
        EntityManagerFactory emf = MyUI.emf;
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Team _team = em.createQuery("select t from teams as t where t.name = :team", Team.class)
                .setParameter("team", team)
                .getSingleResult();
        coach.setTeam(_team);
        em.persist(coach);
        em.getTransaction().commit();

        em.close();
    }

    public static List<Coach> readCoach() {
        EntityManagerFactory emf = MyUI.emf;
        EntityManager em = emf.createEntityManager();
        return em
                .createQuery("select c from coaches as c join fetch c.team", Coach.class)
                .getResultList();

    }

    public static void removeCoach(Coach coach) {
        List<Coach> edzok = readCoach();
        EntityManagerFactory emf = MyUI.emf;
        EntityManager em = emf.createEntityManager();

        Coach temp = null;
        for (Coach e : edzok) {
            if (e.getLastName().equals(coach.getLastName())) {
                temp = e;
                break;
            }

        }
        em.getTransaction().begin();

        Coach xmp = em.merge(temp);
        em.remove(xmp);
        em.getTransaction().commit();

        em.close();
    }

    public static Coach getCoach(Long id) {

        try {
            EntityManagerFactory emf = MyUI.emf;
            EntityManager em = emf.createEntityManager();
            return em
                    //.createQuery("select c from coaches as c join fetch c.team left join fetch t.owner", Team.class)
                    .createQuery("select c from coaches as c where c.id=:id", Coach.class)
                    .setParameter("id", id)
                    .getSingleResult();
            // em.close();
        } catch (NoResultException e) {
            return null;

        }
    }
}
