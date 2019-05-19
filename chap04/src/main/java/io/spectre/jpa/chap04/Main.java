package io.spectre.jpa.chap04;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    final static Logger logger = LoggerFactory.logger(Main.class);

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPrograming");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

//            Board board = new Board();
//            Member member = new Member();
            Board2 board2 = new Board2();

//            em.persist(board);
//            em.persist(member);
            em.persist(board2);

//            logger.info("테스트1" + board.toString());
//            logger.info("테스트2" + member.toString());
            logger.info(board2.toString());
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
