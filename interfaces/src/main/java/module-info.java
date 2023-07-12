module interfaces {
    requires static lombok;
    requires domain;
    requires application;

    requires jakarta.inject;
    requires jakarta.cdi;
    requires jakarta.ws.rs;
    requires io.smallrye.common.annotation;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires jakarta.xml.bind;
    requires microprofile.openapi.api;
    requires microprofile.context.propagation.api;


    provides dev.davidky.visitorlogix.interfaces.employee.facade.EmployeeManagementFacade
            with dev.davidky.visitorlogix.interfaces.employee.facade.internal.DefaultEmployeeManagementFacade;

}