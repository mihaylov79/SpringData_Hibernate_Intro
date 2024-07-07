package SpringData;

import entities.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class exercise_12 {
    public static void main(String[] args) {
        BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        String fromDepartment = entityManager.createQuery("FROM Department ", Department.class).getResultStream().map(d -> {
           double max = d.getEmployees().stream()
                   .mapToDouble( e-> e.getSalary().doubleValue())
                   .max()
                   .orElse(0);

           if (max < 30000 || max > 70000){

               return String.format("%s %.2f", d.getName(), max);
           }else {
               return "";
           }
        }).filter(d-> !d.isEmpty()).collect(Collectors.joining("\n"));
        System.out.println(fromDepartment);



        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
