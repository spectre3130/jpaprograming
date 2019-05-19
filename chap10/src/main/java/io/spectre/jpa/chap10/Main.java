package io.spectre.jpa.chap10;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAQueryFactory;
import io.spectre.jpa.chap10.domain.Member;
import io.spectre.jpa.chap10.domain.QMember;
import org.hibernate.query.NativeQuery;

import javax.persistence.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPrograming");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Member member = new Member();
            member.setUsername("이현호");
            member.setAge(32);
            em.persist(member);

            Member member2 = new Member();
            member2.setUsername("김길동");
            member2.setAge(29);
            em.persist(member2);

            em.flush();
            em.clear();

            JPAQuery query = new JPAQuery(em);
            QMember qMember = QMember.member;

            List<Member> members = query.from(qMember)
                    .list(qMember);

            for (Member member1 : members) {
                System.out.println(member1.toString());
            }

            String sql =
                    "select member_id, age, username, team_id from member where age > ? and username = ?";
            Query nativeQuery = em.createNativeQuery(sql, Member.class)
                    .setParameter(1,20)
                    .setParameter(2, "이현호");

            List<Member> members1 = nativeQuery.getResultList();
            for (Member member1 : members1) {
                System.out.println(member1.toString());
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
