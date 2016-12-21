/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.icontest.soccer.prog.dao;

import hu.icontest.soccer.prog.MyUI;
import hu.icontest.soccer.prog.dto.ResultDto;
import hu.icontest.soccer.prog.model.Coach;
import hu.icontest.soccer.prog.model.Owner;
import hu.icontest.soccer.prog.model.Team;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 *
 * @author developer
 * @since Dec 01, 2016
 */
public class TeamDao {

    public static void addTeam(Team team, String coach, String owner) {

        EntityManagerFactory emf = MyUI.emf;
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Coach _coach = em.createQuery("select c from coaches as c where c.lastName = :coach", Coach.class)
                .setParameter("coach", coach)
                .getSingleResult();
        Owner _owner = em.createQuery("select o from owners as o where o.lastName = :owner", Owner.class)
                .setParameter("owner", owner)
                .getSingleResult();
        team.setCoach(_coach);
        team.setOwner(_owner);
        em.persist(team);
        em.getTransaction().commit();

        //em.createNativeQuery("select * from teams", Team.class);
        em.close();
    }

    public static List<Team> listTeam() {

        /*   EntityManagerFactory emf = MyUI.emf;
        EntityManager em = emf.createEntityManager();

        return em.createNativeQuery("select * from teams", Team.class).getResultList();
         */
        EntityManagerFactory emf = MyUI.emf;
        EntityManager em = emf.createEntityManager();
        return em
                .createQuery("select t from teams as t join fetch t.coach left join fetch t.owner", Team.class)
                .getResultList();
        // em.close();

    }

    public static void deleteTeam(Team team) {
        List<Team> csapatlista = listTeam();
        EntityManagerFactory emf = MyUI.emf;
        EntityManager em = emf.createEntityManager();

        Team temp = null;
        for (Team p : csapatlista) {
            if (p.getName().equals(team.getName())) {
                temp = p;
                break;
            }

        }
        em.getTransaction().begin();

        Team bla = em.merge(temp);
        em.remove(bla);
        em.getTransaction().commit();

        em.close();

    }

    public static Team getTeam(Long id) {

        /*   EntityManagerFactory emf = MyUI.emf;
        EntityManager em = emf.createEntityManager();

        return em.createNativeQuery("select * from teams", Team.class).getResultList();
         */
        try {
            EntityManagerFactory emf = MyUI.emf;
            EntityManager em = emf.createEntityManager();
            return em
                    //.createQuery("select t from teams as t join fetch t.coach left join fetch t.owner", Team.class)
                    .createQuery("select t from teams as t join fetch t.coach left join fetch t.owner where t.id=:id", Team.class)
                    .setParameter("id", id)
                    .getSingleResult();
            // em.close();
        } catch (NoResultException e) {
            return null;
        }
    }
}
