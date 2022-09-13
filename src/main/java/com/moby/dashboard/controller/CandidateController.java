package com.moby.dashboard.controller;

import com.moby.dashboard.persistence.models.dto.CandidateDTO;
import com.moby.dashboard.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
    @Autowired
    private ICandidateService candidateService;


    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody CandidateDTO candidateDTO) {
        candidateService.create(candidateDTO);
        return new ResponseEntity<>("Ok.", HttpStatus.CREATED);
    }




    @GetMapping("/findAll")
    public ResponseEntity<List<CandidateDTO>> findAll() {

        return new ResponseEntity<>(candidateService.findAll(),HttpStatus.OK);
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<CandidateDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(candidateService.findById(id),HttpStatus.OK);
    }



    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateById(@Valid @RequestBody CandidateDTO candidateDTO, @PathVariable("id") Long id) {
        candidateService.updateById(candidateDTO,id);
        return new ResponseEntity<>("Updated id: "+id,HttpStatus.OK);

    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        candidateService.deleteById(id);
        return new ResponseEntity<>("Deleted id: "+id,HttpStatus.OK);

    }
}
