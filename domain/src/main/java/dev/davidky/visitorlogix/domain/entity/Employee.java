package dev.davidky.visitorlogix.domain.entity;

import dev.davidky.visitorlogix.domain.vo.PersonalInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;
import java.util.function.Predicate;

@Builder(builderMethodName = "anEmployee",setterPrefix = "with")
@NoArgsConstructor @AllArgsConstructor
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private PersonalInfo personalInfo;
    private String job;
    private boolean status;

    public void activate() {
        this.status = true;
    }

    public void deactivate() {
        this.status = false;
    }

    public boolean isActive() {
        return status;
    }

    public static Predicate<Employee> getFullNamePredicate(String name) {
        return e->e.personalInfo.getFirstName().contains(name) ||
                e.personalInfo.getLastName().contains(name);
    }
}
