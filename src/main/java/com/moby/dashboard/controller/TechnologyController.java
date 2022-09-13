package com.moby.dashboard.controller;

import com.moby.dashboard.persistence.models.dto.TechnologyDTO;
import com.moby.dashboard.service.ITechnologyService;
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
@RequestMapping("/api/technology")
public class TechnologyController {
    @Autowired
    private ITechnologyService technologyService;


    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody TechnologyDTO technologyDTO) {
        technologyService.create(technologyDTO);
        return new ResponseEntity<>("Ok.", HttpStatus.CREATED);
    }




    @GetMapping("/findAll")
    public ResponseEntity<List<TechnologyDTO>> findAll() {

        return new ResponseEntity<>(technologyService.findAll(),HttpStatus.OK);
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<TechnologyDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(technologyService.findById(id),HttpStatus.OK);
    }



    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateById(@Valid @RequestBody TechnologyDTO technologyDTO, @PathVariable("id") Long id) {
        technologyService.updateById(technologyDTO,id);
        return new ResponseEntity<>("Updated id: "+id,HttpStatus.OK);

    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        technologyService.deleteById(id);
        return new ResponseEntity<>("Deleted id: "+id,HttpStatus.OK);

    }
}
