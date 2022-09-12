package com.moby.dashboard.persistence.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "candidate_technology")
@IdClass(CandidateTechnologyId.class)
public class CandidateTechnology {

    @Id
    @ManyToOne
    @JoinColumn(name = "candidate_id",referencedColumnName = "id")
    private Candidate candidate;

    @Id
    @ManyToOne
    @JoinColumn(name = "technology_id",referencedColumnName = "id")
    private Technology technology;

    @Size(min = 0,message = "Years of experience must be greater than zero.")
    @NonNull
    @Column(name = "year_of_experience")
    private Integer yearOfExperience;

}
