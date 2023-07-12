package dev.davidky.visitorlogix.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter
public class Badge {
    private String number;
    private BadgeType badgeType;
}
