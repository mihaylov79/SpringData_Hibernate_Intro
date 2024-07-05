package SpringData;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class exercise_5 {

    public static void main(String[] args) {

        BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager
                .createQuery("SELECT e FROM Employee e JOIN e.department d WHERE d.name = 'Research and Development' ORDER BY e.salary, e.id", Employee.class).getResultStream().forEach(e -> System.out.printf(" %s %s from Research and Departments - $%.2f%n",
                        e.getFirstName(),e.getLastName(), e.getSalary()));

    }
}
