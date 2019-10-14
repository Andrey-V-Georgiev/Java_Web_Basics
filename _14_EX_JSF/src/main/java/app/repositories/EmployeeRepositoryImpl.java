package app.repositories;

import app.domain.entities.Employee;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;


public class EmployeeRepositoryImpl implements EmployeeRepository {

    private EntityManager entityManager;

    public EmployeeRepositoryImpl() {
    }

    @Inject
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee save(Employee employee) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(employee);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
            System.out.println(e);
            System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        this.entityManager.getTransaction().begin();
        List<Employee> employees = this.entityManager
                .createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return employees;
    }

    @Override
    public Employee findById(String id) {
        this.entityManager.getTransaction().begin();
        Employee employee = this.entityManager
                .createQuery("SELECT e FROM Employee e WHERE e.id=:id", Employee.class)
                .setParameter("id", id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();

        return employee;
    }

    @Override
    public BigDecimal salariesSum() {
        try {
            this.entityManager.getTransaction().begin();
            BigDecimal salariesSum = new BigDecimal(this.entityManager
                    .createQuery("SELECT SUM(salary) FROM Employee")
                    .getSingleResult()
                    .toString());
            this.entityManager.getTransaction().commit();
            return salariesSum;
        } catch (Exception e) {
            return new BigDecimal("0");
        }

    }

    @Override
    public BigDecimal averageSalary() {
        try {
            this.entityManager.getTransaction().begin();
            BigDecimal averageSalary = new BigDecimal(this.entityManager
                    .createQuery("SELECT AVG(salary) FROM Employee")
                    .getSingleResult()
                    .toString());
            this.entityManager.getTransaction().commit();
            return averageSalary;
        } catch (Exception e) {
            return new BigDecimal("0");
        }
    }

    @Override
    public void removeById(String id) {

        try {
            this.entityManager.getTransaction().begin();
            this.entityManager
                    .createQuery("DELETE FROM Employee e WHERE e.id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
            System.out.println(String.format("Received id: %s", id));
            System.out.println(e);
            System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
        }
    }
}
