package dev.davidky.visitorlogix.domain.vo;

import lombok.*;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class PersonalInfo {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String picture;
}
