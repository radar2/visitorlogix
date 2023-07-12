package dev.davidky.visitorlogix.domain.shared;

import dev.davidky.visitorlogix.domain.entity.Employee;

public class EmptyEmployeeSpec extends AbstractSpecification<Employee>{

    @Override
    public boolean isSatisfiedBY(Employee employee) {
        return employee != null && employee.isActive();
    }

    @Override
    public void check(Employee employee) {
        if (!isSatisfiedBY(employee)) {
            throw  new RuntimeException("Employé non actif.");
        }
    }
}
