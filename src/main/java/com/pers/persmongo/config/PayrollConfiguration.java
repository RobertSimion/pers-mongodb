package com.pers.persmongo.config;

import com.pers.persmongo.model.Payroll;
import com.pers.persmongo.util.PayrollGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
public class PayrollConfiguration {

    @Bean("payrolls")
    public List<Payroll> getPayrolls(@Value("${payroll.iterations}") Integer iterations) {
        return PayrollGenerator.setupPayrollLink(iterations, 0);
    }

    @Bean("payrollsToUpdate")
    public List<Payroll> getPayrollsToBeUpdated(@Value("${payroll.iterations}") Integer iterations) {
        return PayrollGenerator.setupPayrollLink(iterations, 1);
    }

}
