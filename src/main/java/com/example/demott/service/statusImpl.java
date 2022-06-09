package com.example.demott.service;

import com.example.demott.mapper.statusMapper;
import com.example.demott.in.inStatus;
import com.example.demott.model.dataStatus;
import com.example.demott.entity.statusEntity;
import com.example.demott.repository.statusRepository;
import com.example.demott.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class statusImpl implements status{

    @Autowired
    private statusRepository statusRepository;
    @Autowired
    private userRepository userRepository;

    @Override
    public dataStatus getData() {
//        List<statusEntity> list = new ArrayList<>();
//        list = statusRepository.findAll();

        return new dataStatus(true,"Truy van thanh cong", statusRepository.findAll());
    }

    @Override
    public statusEntity findItemById(Integer id) {
        statusEntity status = statusRepository.findItemById(id);
        return status;
    }

    @Override
    public dataStatus addStatus(inStatus inStatus) {
        List<statusEntity> foundStatus = statusRepository.findByName(inStatus.getName().trim());
        if (foundStatus.size() > 0){
            return new dataStatus(false,"Thong tin da ton tai","");
        }
        else {
            statusEntity entity = statusRepository.save(statusMapper.mapStatusEntity(inStatus));
            return new dataStatus(true, "thanh cong", entity) ;
        }

    }

    @Override
    public String deleteStatus(Integer id) {
        statusRepository.deleteById(id);
        return "Ok";
    }

    @Override
    public statusEntity updateStatus(Integer id, inStatus inStatus) {
        statusEntity status = statusRepository.findItemById(id);
        status.setName(inStatus.getName());
        status.setPriority(inStatus.getPriority());

        return statusRepository.save(status);
    }

}
