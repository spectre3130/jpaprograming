package io.spectre.jpa.chap07;


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
            Book book = new Book();
            book.setName("JPA프로그래밍");
            book.setPrice(38000);
            book.setAuthor("김영한");
            book.setIsbn("82-1475-88BN");
            em.persist(book);

            Movie movie = new Movie();
            movie.setName("어벤져스 엔드게임");
            movie.setActor("로다주외 다수");
            movie.setDirector("루소 형제");
            em.persist(movie);

            em.flush();
            em.clear();

            List<Book> list = em.createQuery("select b from Book b", Book.class).getResultList();
            for (Book item : list) {
                System.out.println(item.toString());
            }

            List<Movie> list2 = em.createQuery("select m from Movie m", Movie.class).getResultList();
            for (Movie item2 : list2) {
                System.out.println(item2.toString());
            }

            em.flush();
            em.clear();

            Parent parent = new Parent();
            parent.setId1("myId1");
            parent.setId2("myId2");
            parent.setName("parentName");
            em.persist(parent);

            Child child = new Child();
            child.setId("chId1");
            child.setParent(parent);
            em.persist(child);

            Parent parent1 = new Parent();
            parent1.setId1("myId3");
            parent1.setId2("myId4");
            parent1.setName("parentName2");
            em.persist(parent1);

            child.setParent(parent1);

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

