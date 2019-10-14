package app.services;

import app.domain.entities.Employee;
import app.domain.models.service.EmployeeServiceModel;
import app.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    @Inject
    public EmployeeServiceImpl(ModelMapper modelMapper, EmployeeRepository employeeRepository) {
        this.modelMapper = modelMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeServiceModel save(EmployeeServiceModel employeeServiceModel) {
        this.employeeRepository.save(this.modelMapper.map(employeeServiceModel, Employee.class));
        return employeeServiceModel;
    }

    @Override
    public List<EmployeeServiceModel> findAll() {
        return this.employeeRepository.findAll()
                .stream()
                .map(e->this.modelMapper.map(e, EmployeeServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeServiceModel findById(String id) {
        return this.modelMapper
                .map(this.employeeRepository.findById(id), EmployeeServiceModel.class);
    }

    @Override
    public void removeById(String id) {
        this.employeeRepository.removeById(id);
    }

    @Override
    public BigDecimal salariesSum() {
        return this.employeeRepository.salariesSum();
    }

    @Override
    public BigDecimal averageSalary() {
        return this.employeeRepository.averageSalary();
    }
}
