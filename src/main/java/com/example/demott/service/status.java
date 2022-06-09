package com.example.demott.service;

import com.example.demott.in.inStatus;
import com.example.demott.model.dataStatus;
import com.example.demott.entity.statusEntity;
import org.springframework.stereotype.Service;

@Service
public interface status {
    dataStatus getData();

    statusEntity findItemById(Integer id);

    dataStatus addStatus(inStatus inStatus);

    String deleteStatus(Integer id);

    statusEntity updateStatus(Integer id, inStatus inStatus);
}
