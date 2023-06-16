package com.pers.persmongo.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee_details")
@Data
@Setter
@Getter
@Builder
public class EmployeeDetails {
    @Id
    private Integer idemployee;
    private String firstname;
    private String lastname;
    private int seniority;
    private String address;
}
