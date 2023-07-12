package dev.davidky.visitorlogix.infrastructure.persistence.jpa.mapper;

import dev.davidky.visitorlogix.domain.entity.Employee;
import dev.davidky.visitorlogix.infrastructure.persistence.jpa.data.EmployeeEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeH2Mapper {

    public EmployeeEntity fromDomain(Employee employee) {
        if(employee != null) {
            EmployeeEntity entity = new EmployeeEntity();
            entity.setId(employee.getId());
            entity.setPersonalInfo(employee.getPersonalInfo());
            entity.setJob(employee.getJob());
            entity.setStatus(employee.isStatus());
            return entity;
        }

        return null;
    }

    public Employee toDomain(EmployeeEntity entity) {
        if (entity != null) {
            return Employee.anEmployee()
                    .withPersonalInfo(entity.getPersonalInfo())
                    .withId(entity.getId())
                    .withJob(entity.getJob())
                    .withStatus(entity.isStatus())
                    .build();

        }

        return null;
    }
}
