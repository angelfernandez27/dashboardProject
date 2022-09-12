package com.moby.dashboard.persistence.models.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class CandidateTechnologyId implements Serializable {

    private Long candidate;
    private Long technology;


}
