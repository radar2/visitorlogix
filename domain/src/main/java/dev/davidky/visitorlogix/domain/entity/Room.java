package dev.davidky.visitorlogix.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Room implements Serializable {

    private Long id;
    private String name;
}
