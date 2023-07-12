package dev.davidky.visitorlogix.application.base;

import dev.davidky.visitorlogix.domain.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeBase {
    void storeEmployee(Employee employee);

    Optional<Employee> findEmployeeWithId(UUID id);

    List<Employee> findAllEmployees();

    void updateEmployee(Employee employee);
}
