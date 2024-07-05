package SpringData;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class exercise_8 {

    public static void main(String[] args) throws IOException {

        BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Employee result = entityManager.createQuery("FROM Employee e WHERE e.id = ?1", Employee.class)
                .setParameter(1, Integer.parseInt(READER.readLine())).getSingleResult();

        System.out.printf("%s %s - %s%n",
                result.getFirstName(),
                result.getLastName(),
                result.getJobTitle());

        result.getProjects().stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p-> System.out.printf("    %s%n",p.getName()));


        entityManager.getTransaction().commit();
    }
}
