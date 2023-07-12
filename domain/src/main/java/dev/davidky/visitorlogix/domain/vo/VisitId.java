package dev.davidky.visitorlogix.domain.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;


@Setter(AccessLevel.PROTECTED)
@Getter
public class VisitId implements Serializable {

    private UUID id;

    private VisitId(UUID id) {
        this.id = id;
    }

    public static VisitId generate() {
        return new VisitId(UUID.randomUUID());
    }


    public static  VisitId fromString(String id) {
        return new VisitId(UUID.fromString(id));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisitId)) return false;
        VisitId visitId = (VisitId) o;
        return Objects.equals(getId(), visitId.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    @Override
    public String toString() {
        return id.toString();
    }
}
