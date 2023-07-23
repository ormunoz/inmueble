package com.inmueble.springbootmicroservice1inmueble.controller;

import com.inmueble.springbootmicroservice1inmueble.model.Inmueble;
import com.inmueble.springbootmicroservice1inmueble.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inmueble/")
public class InmuebleController {

    @Autowired
    private InmuebleService inmuebleService;

    @PostMapping("create")
    public ResponseEntity<?> saveInmueble(@RequestBody Inmueble inmueble){

        return new ResponseEntity<>(
                inmuebleService.saveInmueble(inmueble),
                HttpStatus.CREATED);
    };

    @DeleteMapping("{inmuebleId}/delete")
    public ResponseEntity<?> deleteInmueble(@PathVariable Long inmuebleId){
        inmuebleService.deleteInmueble(inmuebleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllInmuebles(){
        return ResponseEntity.ok(inmuebleService.findAllInmuebles());
    }
}
