package dev.davidky.visitorlogix.infrastructure.persistence.jpa.data;


import dev.davidky.visitorlogix.domain.vo.PersonalInfo;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "employee")
@NamedQuery(name = "EmployeeEntity.findAll", query = "select e from EmployeeEntity e ")
@Data
public class EmployeeEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Embedded
    private PersonalInfo personalInfo;

    private String job;

    private boolean status;

}
