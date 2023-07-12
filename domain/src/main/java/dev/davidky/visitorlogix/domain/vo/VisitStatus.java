package dev.davidky.visitorlogix.domain.vo;

public enum VisitStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED;

    public boolean isPending() {
        return this == PENDING;
    }

    public boolean isProgress() {
        return this == IN_PROGRESS;
    }

    public boolean isCompleted() {
        return this == COMPLETED;
    }
}
