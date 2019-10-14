package app.web.beans;

import app.services.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;

@Named
@RequestScoped
public class EmployeeSalariesBean implements Serializable {

    private EmployeeService employeeService;
    private BigDecimal salariesSum;
    private BigDecimal averageSalary;

    public EmployeeSalariesBean() {
    }

    @Inject
    public EmployeeSalariesBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.setSalariesSum();
        this.setAverageSalary();
    }

    public BigDecimal getSalariesSum() {
        return salariesSum;
    }

    private void setSalariesSum() {
        BigDecimal sum = this.employeeService.salariesSum();
        this.salariesSum = sum.setScale(2, BigDecimal.ROUND_UP);
    }

    public BigDecimal getAverageSalary() {
        return averageSalary;
    }

    private void setAverageSalary() {
        BigDecimal avg = this.employeeService.averageSalary();
        this.averageSalary = avg.setScale(2, BigDecimal.ROUND_UP);
    }
}
