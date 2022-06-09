package com.example.demott.repository;


import com.example.demott.entity.userEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userRepository extends JpaRepository<userEntity, Integer> {


    @Query(value = "select * from user_entity join status_entity on status_entity.id = user_entity.id_status", nativeQuery = true)
    List<userEntity> all();

    @Query(value = "select * from user_entity join status_entity on status_entity.id = user_entity.id_status order by status_entity.priority asc, user_entity.modified_date asc", nativeQuery = true)
    List<userEntity> findAll();
    

    @Query(value = "select * from user_entity join status_entity on status_entity.id = user_entity.id_status where status_entity.priority = 1 and user_entity.modified_date in (select min(user_entity.modified_date) from user_entity join status_entity on status_entity.id = user_entity.id_status where status_entity.priority = 1)", nativeQuery = true)
    List<userEntity> findItem();

    userEntity findUserEntityById(Integer id);

}
