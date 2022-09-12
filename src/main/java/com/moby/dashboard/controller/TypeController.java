package com.moby.dashboard.controller;

import com.moby.dashboard.persistence.models.dto.TypeDTO;
import com.moby.dashboard.service.imp.TypeService;

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
@RequestMapping("/api/type")
public class TypeController {
    @Autowired
    private TypeService typeService;


    @PostMapping("/create")
    public ResponseEntity<String> create( @Valid @RequestBody TypeDTO typeDTO) {
        typeService.create(typeDTO);
        return new ResponseEntity<>("Ok.", HttpStatus.CREATED);
    }




    @GetMapping("/findAll")
    public ResponseEntity<List<TypeDTO>> findAll() {

        return new ResponseEntity<>(typeService.findAll(),HttpStatus.OK);
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<TypeDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(typeService.findById(id),HttpStatus.OK);
    }



    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateById(@Valid @RequestBody TypeDTO typeDTO, @PathVariable("id") Long id) {
        typeService.updateById(typeDTO,id);
        return new ResponseEntity<>("Updated",HttpStatus.OK);

    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> DeleteById(@PathVariable Long id) {
        typeService.DeleteById(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);

    }
}
