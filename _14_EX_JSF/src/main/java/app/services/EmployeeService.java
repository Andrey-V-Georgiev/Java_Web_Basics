package app.services;

import app.domain.models.service.EmployeeServiceModel;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    EmployeeServiceModel save(EmployeeServiceModel employeeServiceModel);

    List<EmployeeServiceModel> findAll();

    EmployeeServiceModel findById(String id);

    void removeById(String id);
}
