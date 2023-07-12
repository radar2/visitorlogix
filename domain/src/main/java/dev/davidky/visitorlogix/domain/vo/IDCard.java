package dev.davidky.visitorlogix.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class IDCard {
    private IDCardAuthority authority;
    private String number;
    private LocalDate validFrom;
    private LocalDate validTo;
}
