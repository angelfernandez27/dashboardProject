package com.moby.dashboard.persistence.models.dto;
import com.moby.dashboard.persistence.models.entity.Candidate;
import com.moby.dashboard.persistence.models.entity.Technology;
import lombok.Data;

@Data
public class CandidateTechnologyDTO {

    private Long id;

    private Candidate candidate;

    private Technology technology;

    private Integer yearOfExperience;

    public CandidateTechnologyDTO() {
    }
}
