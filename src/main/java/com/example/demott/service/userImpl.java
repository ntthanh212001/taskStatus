package com.example.demott.service;

import com.example.demott.mapper.userMapper;
import com.example.demott.in.inUser;
import com.example.demott.entity.userEntity;
import com.example.demott.model.User;
import com.example.demott.model.dataEmployee;
import com.example.demott.model.dataStatus;
import com.example.demott.repository.statusRepository;
import com.example.demott.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Component
public class userImpl implements user{

    @Autowired
    private userRepository userRepository;
    @Autowired
    private statusRepository statusRepository;


    @Override
    public dataEmployee getAll() {
        return new dataEmployee(statusRepository.findAll(), userRepository.all());
    }

    @Override
    public List<userEntity> get() {
        List<userEntity> list = userRepository.all();
        return list;
    }

    @Override
    public User<List<userEntity>> getData() {
        List<userEntity> list = userRepository.findAll();
        return new User<>(list.size(), list);
    }

    @Override
    public List<userEntity> getItem() {
        List<userEntity> list = userRepository.findItem();
        return list;
    }

    @Override
    public userEntity findById(Integer id) {
        return userRepository.findUserEntityById(id);
    }


    @Override
    public userEntity addUser(inUser user) {
        userEntity userEntity = userMapper.mapUserEntity(user);

        userEntity.setStatusentity(statusRepository.getById(user.getStatusentity()));
        return userRepository.save(userEntity);
    }


    @Override
    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return "Ok";
    }

    @Override
    public userEntity updateUser(Integer id, inUser user) {
        userEntity entiti = userRepository.getById(id);
        entiti.setName(user.getName());
        entiti.setStatusentity(statusRepository.getById(user.getStatusentity()));
        entiti.setModifiedDate(Time.valueOf(LocalTime.now()));

        return userRepository.save(entiti);
    }

    @Override
    public List<userEntity> findUserWithSorting(String field) {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    @Override
    public List<userEntity> pagination(Integer offset, Integer pageSize) {
        Sort sort = Sort.by("statusentity", "modifiedDate").ascending();
        Page<userEntity> page = userRepository.findAll(PageRequest.of(offset, pageSize, sort));
        return page.toList();
    }


}
