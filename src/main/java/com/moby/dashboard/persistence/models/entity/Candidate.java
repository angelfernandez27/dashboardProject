package com.moby.dashboard.persistence.models.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Data
@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name field must not be null or empty.")
    private String name;

    @NotBlank(message = "lastname field must not be null or empty.")
    private String lastname;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="type_document_id",referencedColumnName = "id",nullable = false)
    private TypeDocument typeDocument;

    @NotBlank(message = "documentNumber field must not be null or empty.")
    private String documentNumber;



    @NotNull(message = "date of birth must not be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;




}
