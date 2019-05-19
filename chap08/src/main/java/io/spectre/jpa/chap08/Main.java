package io.spectre.jpa.chap08;

import javassist.expr.Instanceof;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    static final Logger logger = LoggerFactory.logger(Main.class);

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPrograming");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Team newTeam = new Team();
            newTeam.setName("연구소");
            em.persist(newTeam);
            Member newMember = new Member();
            newMember.setUsername("member1");
            newMember.setTeam(newTeam);
            em.persist(newMember);

            em.flush();
            em.clear();

            Member member = em.getReference(Member.class, 2L);
            System.out.println(member.getUsername());
            System.out.println(emf.getPersistenceUnitUtil().isLoaded(member));
            System.out.println("member proxy name : " + member.getClass().getName());

            System.out.println(member.getTeam().getName());

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }

}
