package com.moby.dashboard.persistence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "name field must not be null or empty")
    private String name;
    @NotBlank(message = "version field must not be null or empty")
    private String version;

    @OneToMany(mappedBy = "technology")
    private List<CandidateTechnology> candidates;


}
