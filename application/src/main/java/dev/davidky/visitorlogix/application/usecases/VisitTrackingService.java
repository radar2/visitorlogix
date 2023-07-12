package dev.davidky.visitorlogix.application.usecases;

import dev.davidky.visitorlogix.domain.entity.Room;
import dev.davidky.visitorlogix.domain.entity.Visit;
import dev.davidky.visitorlogix.domain.entity.Visitor;
import dev.davidky.visitorlogix.domain.vo.Badge;
import dev.davidky.visitorlogix.domain.vo.TimeSlot;
import dev.davidky.visitorlogix.domain.vo.VisitId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VisitTrackingService {

    Visit registerVisit(
            Visitor visitor,
            UUID employeeId,
            String reason,
            TimeSlot timeSlot,
            Room room);


    void addBadgeForVisit(VisitId visitId, Badge badge);

    void progressVisit(VisitId visitId);

    void completeVisit(VisitId id);

    Optional<Visit> findVisitById(VisitId id);

    List<Visit> searchAndRetrieveVisitList();

    List<Visit> retrieveVisitHistoryForVisitor(UUID id);
}
