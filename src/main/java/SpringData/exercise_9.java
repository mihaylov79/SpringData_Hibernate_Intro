package SpringData;

import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class exercise_9 {
    public static void main(String[] args) {

        BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("FROM Project p WHERE p.endDate is null order by p.name", Project.class)
                .setMaxResults(10).getResultList()
                .forEach(p-> System.out.printf("Project name: %s%n   Project Description: %s%n   Project Start Date: %s%n   Project End Date: %s%n"
                        ,p.getName(),p.getDescription(),p.getStartDate(),p.getEndDate()));


        entityManager.getTransaction().commit();
    }
}
