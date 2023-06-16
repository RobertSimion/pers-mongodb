package com.pers.persmongo.service;

import com.pers.persmongo.model.Employee;
import com.pers.persmongo.model.EmployeeDetails;
import com.pers.persmongo.model.Payroll;
import com.pers.persmongo.repository.EmployeeDetailsRepository;
import com.pers.persmongo.repository.EmployeeRepository;
import com.pers.persmongo.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CrudService {
    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    public Optional<Payroll> getPayrollById(Integer idpayroll) {
        return payrollRepository.findById(idpayroll);
    }

    public Payroll addPayroll(Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    public List<Payroll> addPayrolls(List<Payroll> payrolls) {
        return payrollRepository.saveAll(payrolls);
    }

    public Payroll updatePayroll(Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    public void updatePayrolls(List<Payroll> payrolls) {
        List<Payroll> payrollsDb = getAllPayrolls();
        for(int i = 0; i < payrolls.size(); i ++) {
            payrollsDb.get(i).setIdpayroll(payrolls.get(i).getIdpayroll());
            payrollsDb.get(i).setBudget(payrolls.get(i).getBudget());
            payrollsDb.get(i).setBudget(payrolls.get(i).getBudget());
            payrollsDb.get(i).setStatus(payrolls.get(i).getStatus());

            updatePayroll(payrollsDb.get(i));
        }
    }

    public void deletePayrollById(Integer idpayroll) {
        payrollRepository.deleteById(idpayroll);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Integer idemployee) {
        return employeeRepository.findById(idemployee);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Integer idemployee) {
        employeeRepository.deleteById(idemployee);
    }

    public Optional<EmployeeDetails> getEmployeeDetailsById(Integer idemployee) {
        return employeeDetailsRepository.findById(idemployee);
    }

    public EmployeeDetails addEmployeeDetails(EmployeeDetails employeeDetails) {
        return employeeDetailsRepository.save(employeeDetails);
    }

    public EmployeeDetails updateEmployeeDetails(EmployeeDetails employeeDetails) {
        return employeeDetailsRepository.save(employeeDetails);
    }

    public void deleteEmployeeDetailsById(Integer idemployee) {
        employeeDetailsRepository.deleteById(idemployee);
    }

    public Optional<Employee> getEmployeeWithDetailsById(Integer idEmployee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(idEmployee);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            Optional<EmployeeDetails> detailsOptional = employeeDetailsRepository.findById(employee.getEmployeeDetails().getIdemployee());
            detailsOptional.ifPresent(employee::setEmployeeDetails);
            return Optional.of(employee);
        }
        return Optional.empty();
    }

    public Employee addEmployeeWithDetails(Employee employee) {
        EmployeeDetails details = employee.getEmployeeDetails();
        employee.setEmployeeDetails(addEmployeeDetails(details));
        return addEmployee(employee);
    }

    public Employee updateEmployeeWithDetails(Employee employee) {
        EmployeeDetails details = employee.getEmployeeDetails();
        employee.setEmployeeDetails(updateEmployeeDetails(details));
        return updateEmployee(employee);
    }

    public void deleteAll() {
        payrollRepository.deleteAll();
    }
}
