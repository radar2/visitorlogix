package dev.davidky.visitorlogix.application.base;

import dev.davidky.visitorlogix.domain.entity.Visit;
import dev.davidky.visitorlogix.domain.vo.VisitId;

import java.util.List;
import java.util.UUID;

public interface VisitBase {
    void store(Visit visit);
    List<Visit> findVisitInProgress();
    List<Visit> findAllVisit();

    List<Visit> findVisitsForVisitorWithId(UUID id);
}
