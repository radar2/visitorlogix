package dev.davidky.visitorlogix.domain.shared;

import dev.davidky.visitorlogix.domain.vo.BadgeType;

import java.time.LocalTime;

public class DepartureTimeSpec extends AbstractSpecification<LocalTime>{
    private BadgeType badgeType;

    public DepartureTimeSpec(BadgeType badgeType) {
        this.badgeType = badgeType;
    }

    @Override
    public boolean isSatisfiedBY(LocalTime localTime) {

        switch (badgeType) {
            case SERVICE_PROVIDER:
                return true;

            case VISITOR:
                return true;

            default:
                return true;
        }
    }

    @Override
    public void check(LocalTime localTime) {
        if (isSatisfiedBY(localTime)) {
            throw new IllegalArgumentException("Departure time is not allowed.");
        }
    }
}
