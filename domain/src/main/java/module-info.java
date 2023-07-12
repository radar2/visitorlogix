module domain {
    exports dev.davidky.visitorlogix.domain.entity;
    exports dev.davidky.visitorlogix.domain.vo;
    exports dev.davidky.visitorlogix.domain.service;
    requires static lombok;

    requires jakarta.inject;
    requires jakarta.cdi;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.datatype.jsr310;
}