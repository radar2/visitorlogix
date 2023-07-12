package dev.davidky.visitorlogix.domain.entity;

import dev.davidky.visitorlogix.domain.shared.DepartureTimeSpec;
import dev.davidky.visitorlogix.domain.shared.EmptyEmployeeSpec;
import dev.davidky.visitorlogix.domain.vo.Badge;
import dev.davidky.visitorlogix.domain.vo.TimeSlot;
import dev.davidky.visitorlogix.domain.vo.VisitId;
import dev.davidky.visitorlogix.domain.vo.VisitStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data @NoArgsConstructor
public class Visit implements Serializable {
    private static final long serialVersionUID = 1L;

    private VisitId id;
    private Employee employee;
    private Visitor visitor;
    private String reason;
    private TimeSlot timeSlot;
    private Room room;
    private Badge badge;
    private VisitStatus status;

    private Visit(
            VisitId id,
            Employee employee,
            Visitor visitor,
            String reason,
            TimeSlot timeSlot,
            Room room, VisitStatus status) {
        this.id = id;
        this.employee = employee;
        this.visitor = visitor;
        this.reason = reason;
        this.timeSlot = timeSlot;
        this.room = room;
        this.status = status;
    }

    public static Visit newVisit(
            VisitId id,
            Employee employee,
            Visitor visitor,
            String reason,
            TimeSlot timeSlot,
            Room room) {
        EmptyEmployeeSpec employeeSpec = new EmptyEmployeeSpec();
        employeeSpec.check(employee);

        return new Visit(id, employee, visitor, reason, timeSlot,room, VisitStatus.PENDING);
    }

    public void addBadge(Badge badge) {
        this.badge = badge;
    }

    public void progress() {
        this.status = VisitStatus.IN_PROGRESS;
    }

    public void complete() {
        status = VisitStatus.COMPLETED;
    }

    public boolean isInPending() {
        return status.isPending();
    }

    public boolean isInProgress() {
        return status.isProgress();
    }

    public boolean isInCompleted() {
        return status.isCompleted();
    }
}
