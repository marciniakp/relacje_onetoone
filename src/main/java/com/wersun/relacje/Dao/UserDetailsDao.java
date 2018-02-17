package com.wersun.relacje.Dao;

import com.wersun.relacje.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDetailsDao {

    EntityManager entityManager;

    @Autowired
    public UserDetailsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //CRUD

    public UserDetails read(Long id) {
        UserDetails userDetails = entityManager.find(UserDetails.class, id);
        return userDetails;
    }

}
