package app.web.beans;

import app.domain.models.view.EmployeeListViewModel;
import app.services.EmployeeService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class EmployeeListBean {

    private List<EmployeeListViewModel> allEmployees;
    private ModelMapper modelMapper;
    private EmployeeService employeeService;

    public EmployeeListBean() {
    }

    @Inject
    public EmployeeListBean(ModelMapper modelMapper, EmployeeService employeeService) {
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
        this.allEmployees = this.employeeService
                .findAll()
                .stream()
                .map(e-> this.modelMapper.map(e, EmployeeListViewModel.class))
                .collect(Collectors.toList());
    }

    public List<EmployeeListViewModel> getAllEmployees() {
        return allEmployees;
    }

    public void setAllEmployees(List<EmployeeListViewModel> allEmployees) {
        this.allEmployees = allEmployees;
    }
}
