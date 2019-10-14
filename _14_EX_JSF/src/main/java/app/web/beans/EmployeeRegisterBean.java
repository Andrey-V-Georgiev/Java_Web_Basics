package app.web.beans;

import app.domain.models.binding.EmployeeRegisterBindingModel;
import app.domain.models.service.EmployeeServiceModel;
import app.services.EmployeeService;
import org.modelmapper.ModelMapper;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@RequestScoped
public class EmployeeRegisterBean  implements Serializable {

    private EmployeeRegisterBindingModel employeeRegisterBindingModel;
    private ModelMapper modelMapper;
    private EmployeeService employeeService;

    public EmployeeRegisterBean() {
    }

    @Inject
    public EmployeeRegisterBean(ModelMapper modelMapper, EmployeeService employeeService) {
        employeeRegisterBindingModel = new EmployeeRegisterBindingModel();
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
    }

    public EmployeeRegisterBindingModel getEmployeeRegisterBindingModel() {
        return employeeRegisterBindingModel;
    }

    public void setEmployeeRegisterBindingModel(EmployeeRegisterBindingModel employeeRegisterBindingModel) {
        this.employeeRegisterBindingModel = employeeRegisterBindingModel;
    }


    public void register() throws IOException {
        System.out.println(employeeRegisterBindingModel);
        this.employeeService.save(this.modelMapper.map(this.employeeRegisterBindingModel, EmployeeServiceModel.class));

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("/");
    }
}
