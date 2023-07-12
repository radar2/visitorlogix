package dev.davidky.visitorlogix.infrastructure.persistence.jpa;

import dev.davidky.visitorlogix.application.base.EmployeeBase;
import dev.davidky.visitorlogix.domain.entity.Employee;
import dev.davidky.visitorlogix.infrastructure.persistence.jpa.data.EmployeeEntity;
import dev.davidky.visitorlogix.infrastructure.persistence.jpa.mapper.EmployeeH2Mapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class PersistentH2EmployeeBase implements EmployeeBase {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private EmployeeH2Mapper mapper;

    @Override
    public void storeEmployee(Employee employee) {
        EmployeeEntity entity = mapper.fromDomain(employee);
        entityManager.persist(entity);
    }

    @Override
    public Optional<Employee> findEmployeeWithId(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> findAllEmployees() {
        return entityManager
                .createNamedQuery("EmployeeEntity.findAll", EmployeeEntity.class)
                .getResultList()
                .stream().map(e->  mapper.toDomain(e))
                .collect(Collectors.toList());
    }


    @Override
    public void updateEmployee(Employee employee) {

    }
}
