package SpringData;

import entities.Employee;
import org.hibernate.sql.Select;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

public class exercise_10 {
    public static void main(String[] args) {
        BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e JOIN e.department d " +
                        "WHERE d.name IN ( 'Engineering', 'Tool Design', 'Marketing', 'Information Services')", Employee.class)
                .getResultList();
        



        for (Employee employee:employees){
            employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
            entityManager.persist(employee);

            System.out.printf("%s %s ($%.2f)%n",employee.getFirstName(),employee.getLastName(),employee.getSalary());
        }


        entityManager.getTransaction().commit();
    }
}
