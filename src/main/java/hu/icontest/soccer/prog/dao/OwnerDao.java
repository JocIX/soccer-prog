/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.icontest.soccer.prog.dao;

import hu.icontest.soccer.prog.MyUI;
import hu.icontest.soccer.prog.model.Owner;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 *
 * @author developer
 * @since Dec 01, 2016
 */
public class OwnerDao {

    public static void addOwner(Owner owner) {
        EntityManagerFactory emf = MyUI.emf;
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(owner);
        em.getTransaction().commit();

        em.close();
    }

    public static List<Owner> getOwners() {
        EntityManagerFactory emf = MyUI.emf;
        EntityManager em = emf.createEntityManager();
        return em
                .createQuery("select o from owners as o join fetch o.currentTeam", Owner.class)
                .getResultList();

    }

    public static Owner getOwner(Long id) {

        try {
            EntityManagerFactory emf = MyUI.emf;
            EntityManager em = emf.createEntityManager();
            return em
                    //.createQuery("select c from coaches as c join fetch c.team left join fetch t.owner", Team.class)
                    .createQuery("select o from owners as o where o.id=:id", Owner.class)
                    .setParameter("id", id)
                    .getSingleResult();
            // em.close();
        } catch (NoResultException e) {
            return null;

        }
    }
}
