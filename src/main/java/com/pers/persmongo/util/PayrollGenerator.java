package com.pers.persmongo.util;

import com.pers.persmongo.model.Employee;
import com.pers.persmongo.model.EmployeeDetails;
import com.pers.persmongo.model.Payroll;

import java.util.LinkedList;
import java.util.List;

public class PayrollGenerator {

    public static List<Payroll> setupPayrollLink(int iterations, int bias) {
        List<Payroll> payrolls = new LinkedList<>();
        for (int i = 0; i < iterations; i++) {
            List<Employee> employeeList = new LinkedList<>();
            EmployeeDetails employeeDetails = EmployeeDetails.builder()
                    .idemployee(10 * i + bias)
                    .firstname("FirstName " + bias)
                    .lastname("LastName " + bias)
                    .seniority(0 + bias)
                    .address("Street " + i + bias)
                    .build();
            Employee employee = Employee.builder()
                    .idemployee(10 * i + bias)
                    .salary(i + bias)
                    .position("Position " + bias)
                    .employeeDetails(employeeDetails)
                    .build();
            employeeList.add(employee);

            Payroll payroll = Payroll.builder()
                    .idpayroll(i + bias)
                    .status("Ok" + bias)
                    .budget(i + bias)
                    .employees(employeeList)
                    .build();
            payrolls.add(payroll);
        }

        return payrolls;
    }
}