package com.pers.persmongo;

import com.pers.persmongo.model.Payroll;
import com.pers.persmongo.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.Duration;
import java.time.Instant;
import java.util.List;


@SpringBootApplication
public class PersMongoApplication implements CommandLineRunner {

    private static List<Payroll> payrolls;

    private static List<Payroll> payrollsToBeUpdate;

    @Autowired
    private CrudService crudService;

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(PersMongoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        payrolls = applicationContext.getBean("payrolls", List.class);
//        System.out.println(payrolls.size());
//        System.out.println(payrolls);
        payrollsToBeUpdate = applicationContext.getBean("payrollsToUpdate", List.class);
//        System.out.println(payrollsToBeUpdate.size());
//        System.out.println(payrollsToBeUpdate);

        deleteBench();

        insertBench();

        selectBench();

        updateBench();

//        deleteBench();
    }

    private void insertBench() {
        Instant start = Instant.now();
        crudService.addPayrolls(payrolls);
        Instant end = Instant.now();

        Duration elapsedTime = Duration.between(start, end);
        System.out.println("Insert took " + elapsedTime.toMillis());
    }

    private void selectBench() {
        Instant start = Instant.now();
        List<Payroll> resultSet = crudService.getAllPayrolls();
//        System.out.println("Select: " + resultSet);
        Instant end = Instant.now();

        Duration elapsedTime = Duration.between(start, end);
        System.out.println("Select took " + elapsedTime.toMillis());
    }

    private void updateBench() {
        Instant start = Instant.now();
        crudService.updatePayrolls(payrollsToBeUpdate);
        Instant end = Instant.now();

        Duration elapsedTime = Duration.between(start, end);
        System.out.println("Update took " + elapsedTime.toMillis());
    }

    private void deleteBench() {
        Instant start = Instant.now();
        crudService.deleteAll();
        Instant end = Instant.now();

        Duration elapsedTime = Duration.between(start, end);
        System.out.println("Delete took " + elapsedTime.toMillis());
    }



}
