package dev.davidky.visitorlogix.domain.vo;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class TimeSlot {

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
}
