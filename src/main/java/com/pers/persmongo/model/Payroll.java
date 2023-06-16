package com.pers.persmongo.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "payrolls")
@Data
@Setter
@Builder
@Getter
public class Payroll {
    @Id
    private Integer idpayroll;
    private String status;
    private double budget;
    private List<Employee> employees;
}
