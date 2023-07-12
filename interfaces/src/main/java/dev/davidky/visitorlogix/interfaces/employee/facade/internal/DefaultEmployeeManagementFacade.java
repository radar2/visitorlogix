package dev.davidky.visitorlogix.interfaces.employee.facade.internal;

import dev.davidky.visitorlogix.application.base.EmployeeBase;
import dev.davidky.visitorlogix.application.usecases.EmployeeManagement;
import dev.davidky.visitorlogix.domain.entity.Employee;
import dev.davidky.visitorlogix.interfaces.employee.facade.EmployeeManagementFacade;
import dev.davidky.visitorlogix.interfaces.employee.facade.dto.CreatedEmployeeDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class DefaultEmployeeManagementFacade implements EmployeeManagementFacade {

    @Inject
    private EmployeeManagement employeeManagement;

    @Override
    public Employee createEmployee(CreatedEmployeeDTO dto) {
        return employeeManagement.createEmployee(
                dto.getFirstname(),
                dto.getLastname(),
                dto.getPhoneNumber(),
                dto.getEmail(),
                dto.getJob());
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeManagement.getEmployeeList();
    }

    @Override
    public Optional<Employee> findEmployeeById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> searchEmployeeWithName(String name) {
        return null;
    }

    @Override
    public void activateEmployee(UUID id) {

    }

    @Override
    public void desactivateEmployee(UUID id) {

    }

    @Override
    public void setBase(EmployeeBase employeeBase) {

    }
}
