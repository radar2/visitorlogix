package dev.davidky.visitorlogix.interfaces.employee.facade;

import dev.davidky.visitorlogix.application.base.EmployeeBase;
import dev.davidky.visitorlogix.application.usecases.EmployeeManagement;
import dev.davidky.visitorlogix.domain.entity.Employee;
import dev.davidky.visitorlogix.interfaces.employee.facade.dto.CreatedEmployeeDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeManagementFacade {
    Employee createEmployee(CreatedEmployeeDTO dto);

    List<Employee> getEmployeeList();

    Optional<Employee> findEmployeeById(UUID id);

    List<Employee> searchEmployeeWithName(String name);

    void activateEmployee(UUID id);

    void desactivateEmployee(UUID id);

    void setBase(EmployeeBase employeeBase);
}
