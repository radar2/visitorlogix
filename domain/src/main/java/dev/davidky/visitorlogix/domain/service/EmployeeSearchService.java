package dev.davidky.visitorlogix.domain.service;

import dev.davidky.visitorlogix.domain.entity.Employee;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@ApplicationScoped
public class EmployeeSearchService {


    public List<Employee> employeeWithName(
            List<Employee> employees, Predicate<Employee> predicate) {
        return employees.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
