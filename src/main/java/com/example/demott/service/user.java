package com.example.demott.service;

import com.example.demott.in.inUser;
import com.example.demott.entity.userEntity;
import com.example.demott.model.User;
import com.example.demott.model.dataEmployee;
import com.example.demott.model.dataStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface user {

    dataEmployee getAll();

    List<userEntity> get();

    User<List<userEntity>> getData();

    List<userEntity> getItem();


    userEntity findById(Integer id);

    userEntity addUser(inUser user);

    String deleteUser(Integer id);

    userEntity updateUser(Integer id, inUser user);

    List<userEntity> findUserWithSorting(String field);

    List<userEntity> pagination(Integer offset, Integer pageSize);
}
