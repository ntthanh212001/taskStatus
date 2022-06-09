package com.example.demott.controller;

import com.example.demott.in.inStatus;
import com.example.demott.entity.statusEntity;
import com.example.demott.service.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/status")
public class statusController {
    @Autowired
    private status status;

    @GetMapping("")
    public ResponseEntity<?> getDataStatus(){
        return new ResponseEntity<>(status.getData(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getItems(@RequestParam Integer id){
        return new ResponseEntity<>(status.findItemById(id), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> addData(@RequestBody inStatus statusIn) {
        return new ResponseEntity<>(status.addStatus(statusIn), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "")
    public ResponseEntity<?> deleteData(@RequestParam Integer id) {
        return new ResponseEntity<>(status.deleteStatus(id), HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<?> updateData(@RequestParam Integer id, @RequestBody inStatus statusIn) {
        return new ResponseEntity<statusEntity>(status.updateStatus(id, statusIn), HttpStatus.OK);
    }
}
