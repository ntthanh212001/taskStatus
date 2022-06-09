package com.example.demott.mapper;
import com.example.demott.dto.dtoStatus;
import com.example.demott.in.inStatus;
import com.example.demott.entity.statusEntity;

public class statusMapper {
    public static statusEntity mapStatusEntity(inStatus statusIn){
        statusEntity statusEntity = new statusEntity();
        statusEntity.setName(statusIn.getName());
        statusEntity.setPriority(statusIn.getPriority());
        return statusEntity;
    }

    public static dtoStatus mapDtoStatus(statusEntity statusEntity){
        dtoStatus statusDto = new dtoStatus();
        statusDto.setId(Math.toIntExact(statusEntity.getId()));
        statusDto.setName(statusEntity.getName());
        statusDto.setPriority(statusDto.getPriority());
        return statusDto;
    }
}
