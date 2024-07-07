package SpringData;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exercise_11 {

    public static void main(String[] args) throws IOException {

        BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("FROM Employee WHERE firstName LIKE CONCAT(:letters, '%')", Employee.class)
                .setParameter("letters", READER.readLine())
                .getResultStream().forEach( e ->
                        System.out.printf("%s %s - %s - ($%.2f)%n",e.getFirstName(),e.getLastName(),e.getJobTitle(),e.getSalary()));


        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
