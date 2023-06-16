package com.pers.persmongo.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
@Data
@Setter
@Getter
@Builder
public class Employee {
    @Id
    private Integer idemployee;
    private double salary;
    private String position;
    private EmployeeDetails employeeDetails;
}
