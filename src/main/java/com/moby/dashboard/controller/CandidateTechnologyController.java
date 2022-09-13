package com.moby.dashboard.controller;
import com.moby.dashboard.persistence.models.dto.CandidateTechnologyDTO;
import com.moby.dashboard.service.ICandidateTechnologyService;
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
@RequestMapping("/api/candidatetechnology")
public class CandidateTechnologyController {

    @Autowired
    private ICandidateTechnologyService candidateTechnologyService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody CandidateTechnologyDTO candidateTechnologyDTO) {
        candidateTechnologyService.create(candidateTechnologyDTO);
        return new ResponseEntity<>("Ok.", HttpStatus.CREATED);
    }




    @GetMapping("/findAll")
    public ResponseEntity<List<CandidateTechnologyDTO>> findAll() {

        return new ResponseEntity<>(candidateTechnologyService.findAll(),HttpStatus.OK);
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<CandidateTechnologyDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(candidateTechnologyService.findById(id),HttpStatus.OK);
    }



    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateById(@Valid @RequestBody CandidateTechnologyDTO candidateTechnologyDTO, @PathVariable("id") Long id) {
        candidateTechnologyService.updateById(candidateTechnologyDTO,id);
        return new ResponseEntity<>("Updated id: "+id,HttpStatus.OK);

    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        candidateTechnologyService.deleteById(id);
        return new ResponseEntity<>("Deleted id: "+id,HttpStatus.OK);

    }
}
