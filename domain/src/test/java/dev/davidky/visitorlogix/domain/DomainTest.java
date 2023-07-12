package dev.davidky.visitorlogix.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.davidky.visitorlogix.domain.entity.Employee;
import dev.davidky.visitorlogix.domain.entity.Visit;
import dev.davidky.visitorlogix.domain.entity.Visitor;
import dev.davidky.visitorlogix.domain.vo.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class DomainTest {
    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_PATTERN).withZone(ZoneId.systemDefault());

    @Test
    public void registerVisitAndIsInPending() {
        Visitor visitor = getVisitor();
        System.out.println(jsonSerializer(visitor));
        Employee employee = getEmployee();
        employee.activate();
        Visit visit = Visit.newVisit(
                VisitId.generate(),
                employee,
                visitor,
                "WORK",
                TimeSlot.builder()
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now())
                        .arrivalTime(LocalTime.now())
                        .departureTime(LocalTime.now().plusHours(3))
                        .build(),
                null);

        assertTrue(visit.isInPending());


    }

    @Test
    public void registerVisitWithDesActivatedEmployeeShouldBeRejected() {
        Visitor visitor = getVisitor();
        Employee employee = getEmployee();
        assertFalse(employee.isActive());

        Visit.newVisit(
                VisitId.generate(),
                employee,
                visitor,
                "WORK",
                TimeSlot.builder()
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now())
                        .arrivalTime(LocalTime.now())
                        .departureTime(LocalTime.now().plusHours(3))
                        .build(),
                null);

    }

    @Test
    public void registerVisitWithoutEmployeeShouldBeRejected() {
        Visitor visitor = getVisitor();

        Visit.newVisit(
                VisitId.generate(),
                null,
                visitor,
                "WORK",
                TimeSlot.builder()
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now())
                        .arrivalTime(LocalTime.now())
                        .departureTime(LocalTime.now().plusHours(3))
                        .build(),
                null);
    }

    @Test
    public void progressVisitWithoutBadgeShouldFail() {
        Visitor visitor = getVisitor();
        Employee employee = getEmployee();
        employee.activate();
        Visit visit = Visit.newVisit(
                VisitId.generate(),
                employee,
                visitor,
                "WORK",
                TimeSlot.builder()
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now())
                        .arrivalTime(LocalTime.now())
                        .departureTime(LocalTime.now().plusHours(3))
                        .build(),
                null);

        assertTrue(visit.isInProgress());
    }

    @Test
    public void progressVisit() {
        Visitor visitor = getVisitor();
        Employee employee = getEmployee();
        employee.activate();
        Visit visit = Visit.newVisit(
                VisitId.generate(),
                employee,
                visitor,
                "WORK",
                TimeSlot.builder()
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now())
                        .arrivalTime(LocalTime.now())
                        .departureTime(LocalTime.now().plusHours(3))
                        .build(),
                null);
        assertTrue(visit.isInPending());
        assertTrue( visit.isInProgress());
    }


    @Test
    public void completeVisit() {
        Visitor visitor = getVisitor();
        Employee employee = getEmployee();
        employee.activate();
        Visit visit = Visit.newVisit(
                VisitId.generate(),
                employee,
                visitor,
                "WORK",
                TimeSlot.builder()
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now())
                        .arrivalTime(LocalTime.now())
                        .departureTime(LocalTime.now().plusHours(3))
                        .build(),
                null);
        visit.progress();
        assertTrue(visit.isInProgress());
        visit.complete();
        assertTrue(visit.isInCompleted());
    }


    private Visitor getVisitor() {
        return Visitor.builder()
                .id(UUID.randomUUID())
                .personalInfo(PersonalInfo.builder()
                        .firstName("Firstname")
                        .lastName("LastName")
                        .phoneNumber("0707159227")
                        .email("securkydroity@gmail.com")
                        .build())
                .idCard(IDCard.builder()
                        .number("CI09876567")
                        .validFrom(LocalDate.parse("13/07/2018", DATE_FORMATTER))
                        .validTo(LocalDate.parse("12/07/2028", DATE_FORMATTER))
                        .authority(IDCardAuthority.CNI)
                        .build())
                .company("VISITLOGIX")
                .build();
    }


    private Employee getEmployee() {
        return Employee.anEmployee()
                .withId(UUID.randomUUID())
                .withPersonalInfo(PersonalInfo.builder()
                        .firstName("Firstname")
                        .lastName("LastName")
                        .phoneNumber("0707159227")
                        .email("securkydroity@gmail.com")
                        .build())
                .withJob("DEV")
                .build();
    }


    private String jsonSerializer(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            String json = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(o);
            return json;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
