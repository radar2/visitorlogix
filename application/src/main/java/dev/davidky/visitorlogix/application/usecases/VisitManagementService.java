package dev.davidky.visitorlogix.application.usecases;

import dev.davidky.visitorlogix.domain.entity.Employee;
import dev.davidky.visitorlogix.domain.entity.Visit;
import dev.davidky.visitorlogix.domain.entity.Visitor;
import dev.davidky.visitorlogix.domain.vo.TimeSlot;
import dev.davidky.visitorlogix.domain.vo.VisitId;

import java.util.List;
import java.util.UUID;

public interface VisitManagementService {
    VisitId registerNewVisit(
            String reason,
            Employee employee,
            TimeSlot timeSlot,
            Visitor visitor);


    List<Visit> retrieveVisitInProgress();

    List<Visit> visitHistoryForVisitor(UUID visitorId);

    List<Visit> listAllVisit();

}
