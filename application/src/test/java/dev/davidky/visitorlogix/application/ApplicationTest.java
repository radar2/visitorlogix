package dev.davidky.visitorlogix.application;

import dev.davidky.visitorlogix.application.usecases.VisitManagementService;
import dev.davidky.visitorlogix.domain.entity.Employee;
import dev.davidky.visitorlogix.domain.entity.Visit;
import dev.davidky.visitorlogix.domain.entity.Visitor;
import dev.davidky.visitorlogix.domain.vo.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-result"})
public class ApplicationTest {
    private Visitor visitor = null;
    private Employee employee = null;

    private VisitManagementService visitManagementService;

    @Given("je saisis les informations requises")
    public void setVisitorInfoPrerequis(){
        visitor = Visitor.builder()
                .personalInfo(PersonalInfo.builder()
                        .firstName("Kouakkou")
                        .lastName("Yao")
                        .phoneNumber("2250707159227")
                        .email("davi@email.com")
                        .build())
                .company("VAS TECHNOLOGIE")
                .idCard(IDCard.builder()
                        .authority(IDCardAuthority.CNI)
                        .number("CI9876567")
                        .validFrom(LocalDate.parse("20/07/2018"))
                        .validTo(LocalDate.parse("19/07/2028"))
                        .build())
                .build();

        Assertions.assertNotNull(visitor);
    }


    @And(" recherche les informations de l'employe")
    public void assertEmployeeExists(){
        employee = Employee.anEmployee()
                .withPersonalInfo(PersonalInfo.builder()
                        .firstName("Kouakkou")
                        .lastName("Yao")
                        .phoneNumber("2250707159227")
                        .email("davi@email.com")
                        .build())
                .withJob("IT Lead")
                .build();

        assertNotNull(employee);
    }

    @When("je valide l'enregistrement")
    public void validate() {
        VisitId visitId = visitManagementService.registerNewVisit(
                "FOR WORK",
                employee,
                TimeSlot.builder()
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now())
                        .arrivalTime(LocalTime.now())
                        .departureTime(LocalTime.now().plusHours(5))
                        .build(),
                visitor);
        assertNotNull(visitId);
    }
}
