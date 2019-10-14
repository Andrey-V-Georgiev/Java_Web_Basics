package app.repositories;

import app.domain.entities.Employee;

import java.math.BigDecimal;

public interface EmployeeRepository extends GenericRepository<Employee, String> {

    BigDecimal salariesSum();

    BigDecimal averageSalary();
}
