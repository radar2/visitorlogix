package dev.davidky.visitorlogix.application.usecases;

import dev.davidky.visitorlogix.application.base.EmployeeBase;
import dev.davidky.visitorlogix.domain.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeManagement {

    Employee createEmployee(
            String firstName,
            String lastName,
            String phoneNumber,
            String email,
            String job);

    List<Employee> getEmployeeList();

    Optional<Employee> findEmployeeById(UUID id);

    List<Employee> searchEmployeeWithName(String name);

    void activateEmployee(UUID id);

    void desactivateEmployee(UUID id);

    void setBase(EmployeeBase employeeBase);


}
