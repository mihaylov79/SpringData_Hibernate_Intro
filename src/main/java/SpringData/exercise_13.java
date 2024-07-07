package SpringData;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class exercise_13 {
    public static void main(String[] args) {
        BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("DELETE FROM Town WHERE name = ?1", Town.class);


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
