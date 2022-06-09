package com.example.demott.controller;

import com.example.demott.entity.statusEntity;
import com.example.demott.entity.userEntity;
import com.example.demott.in.inUser;
import com.example.demott.model.User;
import com.example.demott.model.dataEmployee;
import com.example.demott.repository.statusRepository;
import com.example.demott.service.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/candidate")
public class userController {
    @Autowired
    private user user;

    @Autowired
    private statusRepository statusrepository;

    @GetMapping(value = "")
    public dataEmployee getAll(){
        List<userEntity> list = user.get();
        List<statusEntity> listStatus = statusrepository.findAll();
        return new dataEmployee(list, listStatus);
    }


    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User<List<userEntity>> getAllWithSort(@PathVariable String field){
        List<userEntity> list = user.findUserWithSorting(field);
        return new User<List<userEntity>>(list.size(), list);
    }

    @GetMapping(value = "/candidate/priority")
    public ResponseEntity<?> getData(){
        return new ResponseEntity<>(user.getData(), HttpStatus.OK);
    }
    
    @GetMapping(value = "/getCandidate")
    public ResponseEntity<?> getUser(){
        return new ResponseEntity<>(user.getItem(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        return new ResponseEntity<userEntity>(user.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> addUser(@RequestBody inUser userIn) {
        return new ResponseEntity<>(user.addUser(userIn), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "")
    public ResponseEntity<?> deleteUser(@RequestParam Integer id) {
        return new ResponseEntity<>(user.deleteUser(id), HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<?> updateUser(@RequestParam Integer id, @RequestBody inUser inuser) {
        return new ResponseEntity<>(user.updateUser(id, inuser), HttpStatus.OK);
    }

    @GetMapping(value = "/pagination")
    public ResponseEntity<?> pagination(@RequestParam Integer offset, @RequestParam Integer pageSize){

        return new ResponseEntity<>(user.pagination(offset,pageSize), HttpStatus.OK);
    }
}
