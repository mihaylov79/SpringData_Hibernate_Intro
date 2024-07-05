package SpringData;

import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class exercise_7 {

    public static void main(String[] args) {

        BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();

        entityManager.createQuery("FROM Address ORDER BY employees.size", Address.class)
                .setMaxResults(10).getResultList().forEach(a -> System.out.printf("%s, %s - %d employees%n", a.getText(), a.getTown().getName(), a.getEmployees().size() ));


        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
