package app.services;

import app.domain.models.service.EmployeeServiceModel;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {

    EmployeeServiceModel save(EmployeeServiceModel employeeServiceModel);

    List<EmployeeServiceModel> findAll();

    EmployeeServiceModel findById(String id);

    void removeById(String id);

    BigDecimal salariesSum();

    BigDecimal averageSalary();
}
