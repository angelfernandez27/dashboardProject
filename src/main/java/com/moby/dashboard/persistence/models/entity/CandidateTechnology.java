package com.moby.dashboard.persistence.models.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "candidate_technology")
public class CandidateTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "candidate_id",referencedColumnName = "id")
    private Candidate candidate;


    @ManyToOne
    @JoinColumn(name = "technology_id",referencedColumnName = "id")
    private Technology technology;


    @NonNull
    @Column(name = "year_of_experience")
    private Integer yearOfExperience;

    public CandidateTechnology() {
    }
}
