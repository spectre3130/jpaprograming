package io.spectre.jpa.chap05;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPrograming");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Team team = new Team("팀1");
            Member member1 = new Member("테스트1");
//            Member member2 = new Member("테스트2");
//            member1.setTeam(team);
//            member2.setTeam(team);

            team.addMember(member1);
//            team.addMember(member2);

//            em.persist(team);
//            em.persist(member1);
//            em.persist(member2);

//            em.flush();
//            em.clear();
//
//            team = em.find(Team.class, (long)1);
            List<Member> members = team.getMembers();
            for (Member member : members) {
                System.out.println("member.username = " + member.getUsername() + "\nmember.team = " + member.getTeam().getName());
            }
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
