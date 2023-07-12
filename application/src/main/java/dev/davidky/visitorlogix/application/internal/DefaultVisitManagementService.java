package dev.davidky.visitorlogix.application.internal;

import dev.davidky.visitorlogix.application.base.VisitBase;
import dev.davidky.visitorlogix.application.usecases.VisitManagementService;
import dev.davidky.visitorlogix.domain.entity.Employee;
import dev.davidky.visitorlogix.domain.entity.Visit;
import dev.davidky.visitorlogix.domain.entity.Visitor;
import dev.davidky.visitorlogix.domain.vo.TimeSlot;
import dev.davidky.visitorlogix.domain.vo.VisitId;
import dev.davidky.visitorlogix.domain.vo.VisitStatus;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;


public class DefaultVisitManagementService implements VisitManagementService {

    @Inject
    private VisitBase visitBase;

    @Override
    public VisitId registerNewVisit(
            String reason,
            Employee employee,
            TimeSlot timeSlot,
            Visitor visitor) {

        Visit visit = Visit.newVisit(
                VisitId.generate(), employee,
                visitor, reason, timeSlot, null);

        visitBase.store(visit);

        return visit.getId();
    }

    @Override
    public List<Visit> retrieveVisitInProgress() {
        return visitBase.findVisitInProgress();
    }

    @Override
    public List<Visit> visitHistoryForVisitor(UUID visitorId) {
        return visitBase.findVisitsForVisitorWithId(visitorId);
    }

    @Override
    public List<Visit> listAllVisit() {
        return visitBase.findAllVisit();
    }
}
