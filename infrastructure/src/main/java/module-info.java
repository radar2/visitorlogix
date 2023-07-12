import dev.davidky.visitorlogix.infrastructure.persistence.jpa.PersistentH2EmployeeBase;

module infrastructure {
    requires static lombok;
    requires jakarta.persistence;
    requires org.eclipse.persistence.core;
    requires java.sql;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires domain;
    requires jakarta.cdi;
    requires jakarta.inject;
    requires application;


    provides dev.davidky.visitorlogix.application.base.EmployeeBase
            with PersistentH2EmployeeBase;


}