package dev.davidky.visitorlogix.interfaces.employee.facade.dto;

import lombok.Data;

@Data
public class CreatedEmployeeDTO {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String job;
}
