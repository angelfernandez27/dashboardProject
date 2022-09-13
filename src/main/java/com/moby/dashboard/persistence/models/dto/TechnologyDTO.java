package com.moby.dashboard.persistence.models.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TechnologyDTO {
    private Long id;

    private String name;

    private String version;


}
