package com.moby.dashboard.controller;

import com.moby.dashboard.persistence.models.dto.TypeDocumentDTO;
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
    public ResponseEntity<String> create( @Valid @RequestBody TypeDocumentDTO typeDocumentDTO) {
        typeService.create(typeDocumentDTO);
        return new ResponseEntity<>("Ok.", HttpStatus.CREATED);
    }




    @GetMapping("/findAll")
    public ResponseEntity<List<TypeDocumentDTO>> findAll() {

        return new ResponseEntity<>(typeService.findAll(),HttpStatus.OK);
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<TypeDocumentDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(typeService.findById(id),HttpStatus.OK);
    }



    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateById(@Valid @RequestBody TypeDocumentDTO typeDocumentDTO, @PathVariable("id") Long id) {
        typeService.updateById(typeDocumentDTO,id);
        return new ResponseEntity<>("Updated id: "+id,HttpStatus.OK);

    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        typeService.deleteById(id);
        return new ResponseEntity<>("Deleted id: "+id,HttpStatus.OK);

    }
}
