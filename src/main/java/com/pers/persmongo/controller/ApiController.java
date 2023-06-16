package com.pers.persmongo.controller;

import com.pers.persmongo.model.Employee;
import com.pers.persmongo.model.Payroll;
import com.pers.persmongo.repository.EmployeeDetailsRepository;
import com.pers.persmongo.repository.EmployeeRepository;
import com.pers.persmongo.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    @GetMapping("/payrolls")
    public List<Payroll> getPayrolls() {
        return payrollRepository.findAll();
    }

    @PostMapping("/payrolls")
    public Payroll addPayroll(@RequestBody Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    @GetMapping("/payrolls/{idpayroll}")
    public Optional<Payroll> getPayrollById(@PathVariable Integer idpayroll) {
        return payrollRepository.findById(idpayroll);
    }

    @PutMapping("/payrolls/{idpayroll}")
    public Payroll updatePayroll(@RequestBody Payroll payroll, @PathVariable Integer idpayroll) {
        payroll.setIdpayroll(idpayroll);
        return payrollRepository.save(payroll);
    }

    @DeleteMapping("/payrolls/{idpayroll}")
    public void deletePayroll(@PathVariable Integer idpayroll) {
        payrollRepository.deleteById(idpayroll);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
}
