package com.example.demott.mapper;

import com.example.demott.dto.dtoUser;
import com.example.demott.entity.userEntity;
import com.example.demott.in.inUser;

import java.sql.Time;
import java.time.LocalTime;


public class userMapper {
    public static userEntity mapUserEntity(inUser userIn){
        userEntity user = new userEntity();
        user.setName(userIn.getName());
//        final Long statusentity = userIn.getStatusentity();
//        user.setStatusentity(userIn.getStatusentity());
        user.setModifiedDate(Time.valueOf(LocalTime.now()));
        return user;
    }

    public static dtoUser mapDtoUser(userEntity userEntity){
        dtoUser userdto = new dtoUser();
        userdto.setId(userEntity.getId());
        userdto.setName(userEntity.getName());
        userdto.setStatusentity(userEntity.getStatusentity());
        userdto.setModifiedDate(userEntity.getModifiedDate());
        return userdto;
    }
}
