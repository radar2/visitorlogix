package dev.davidky.visitorlogix.domain.entity;

import dev.davidky.visitorlogix.domain.vo.IDCard;
import dev.davidky.visitorlogix.domain.vo.PersonalInfo;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Setter(AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Visitor implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private PersonalInfo personalInfo;
    private IDCard idCard;
    private String company;
}
