package dev.davidky.visitorlogix.application.internal;

import dev.davidky.visitorlogix.application.usecases.VisitTrackingService;
import dev.davidky.visitorlogix.domain.entity.Room;
import dev.davidky.visitorlogix.domain.entity.Visit;
import dev.davidky.visitorlogix.domain.entity.Visitor;
import dev.davidky.visitorlogix.domain.vo.Badge;
import dev.davidky.visitorlogix.domain.vo.TimeSlot;
import dev.davidky.visitorlogix.domain.vo.VisitId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DefaultVisitTrackingService implements VisitTrackingService {
    @Override
    public Visit registerVisit(Visitor visitor, UUID employeeId, String reason, TimeSlot timeSlot, Room room) {
        return null;
    }

    @Override
    public void addBadgeForVisit(VisitId visitId, Badge badge) {

    }

    @Override
    public void progressVisit(VisitId visitId) {

    }

    @Override
    public void completeVisit(VisitId id) {

    }

    @Override
    public Optional<Visit> findVisitById(VisitId id) {
        return Optional.empty();
    }

    @Override
    public List<Visit> searchAndRetrieveVisitList() {
        return null;
    }

    @Override
    public List<Visit> retrieveVisitHistoryForVisitor(UUID id) {
        return null;
    }
}
