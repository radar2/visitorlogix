import dev.davidky.visitorlogix.application.usecases.EmployeeManagement;
import dev.davidky.visitorlogix.application.usecases.VisitTrackingService;

module application {
    requires domain;
    requires static lombok;

    requires jakarta.cdi;
    requires jakarta.inject;
    requires jakarta.transaction;

    provides EmployeeManagement
            with dev.davidky.visitorlogix.application.internal.DefaultEmployeeManagement;

    provides VisitTrackingService
            with dev.davidky.visitorlogix.application.internal.DefaultVisitTrackingService;

    exports dev.davidky.visitorlogix.application.base;
    exports dev.davidky.visitorlogix.application.usecases;
}