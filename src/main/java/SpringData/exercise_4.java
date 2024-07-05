package SpringData;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class exercise_4 {

    public static void main(String[] args) {
        BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<String>resultList = entityManager
                .createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                .getResultStream().map(Employee::getFirstName).toList();

        resultList.forEach(System.out::println);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
