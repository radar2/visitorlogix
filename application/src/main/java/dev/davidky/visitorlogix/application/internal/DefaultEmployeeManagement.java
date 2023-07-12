package dev.davidky.visitorlogix.application.internal;

import dev.davidky.visitorlogix.application.base.EmployeeBase;
import dev.davidky.visitorlogix.application.usecases.EmployeeManagement;
import dev.davidky.visitorlogix.domain.entity.Employee;
import dev.davidky.visitorlogix.domain.service.EmployeeSearchService;
import dev.davidky.visitorlogix.domain.vo.PersonalInfo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.UUID;
import java.util.function.Predicate;

@ApplicationScoped
public class DefaultEmployeeManagement implements EmployeeManagement {

    @Inject
    private EmployeeBase employeeBase;

    @Inject
    private EmployeeSearchService employeeSearchService;


    @Transactional
    @Override
    public Employee createEmployee(
            String firstName, String lastName,
            String phoneNumber,
            String email, String job) {
        Employee employee = Employee.anEmployee()
                .withId(UUID.randomUUID())
                .withPersonalInfo(PersonalInfo.builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .email(email)
                        .phoneNumber(phoneNumber)
                        .build())
                .withJob(job)
                .build();

        employee.activate();
        employeeBase.storeEmployee(employee);
        return employee;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeBase.findAllEmployees();
    }

    @Override
    public Optional<Employee> findEmployeeById(UUID id) {
        return employeeBase.findEmployeeWithId(id);
    }

    @Override
    public List<Employee> searchEmployeeWithName(String name) {
        Predicate<Employee> predicate = Employee.getFullNamePredicate(name);
        List<Employee> employees = getEmployeeList();
        return employeeSearchService.employeeWithName(employees, predicate);
    }

    @Override
    public void activateEmployee(UUID id) {
        employeeBase.findEmployeeWithId(id)
                .ifPresent(employee -> {
                    employee.activate();
                    employeeBase.updateEmployee(employee);
                });
    }

    @Override
    public void desactivateEmployee(UUID id) {
        employeeBase.findEmployeeWithId(id)
                .ifPresent(employee -> {
                    employee.deactivate();
                    employeeBase.updateEmployee(employee);
                });
    }

    @Override
    public void setBase(EmployeeBase employeeBase) {
        ServiceLoader<EmployeeBase> load = ServiceLoader.load(EmployeeBase.class);
        employeeBase = load.findFirst().get();
    }
}
