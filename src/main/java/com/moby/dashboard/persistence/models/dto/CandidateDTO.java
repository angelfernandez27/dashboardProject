package com.moby.dashboard.persistence.models.dto;

import com.moby.dashboard.persistence.models.entity.CandidateTechnology;
import com.moby.dashboard.persistence.models.entity.TypeDocument;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class CandidateDTO {

    private Long id;

    private String name;

    private String lastname;

    private TypeDocument typeDocument;

    private String documentNumber;

    private LocalDate dateOfBirth;


}
