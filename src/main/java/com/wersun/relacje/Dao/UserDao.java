package com.wersun.relacje.Dao;

import com.wersun.relacje.model.User;
import com.wersun.relacje.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDao {

    EntityManager entityManager;

    @Autowired //lub @Inject z javy EE
    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //CRUD

    public void create(User user) {
        UserDetails userDetails = user.getUserDetails();
        if(userDetails!=null) {
            entityManager.persist(userDetails);
        }
        entityManager.persist(user);
    }

    public User read(Long id) {
        return entityManager.find(User.class, id);
    }

    public void update(User user) {
        UserDetails userDetails = user.getUserDetails();
        if(userDetails!=null){
            userDetails = entityManager.merge(userDetails);
            user.setUserDetails(userDetails);
        }
        entityManager.merge(user);
    }

    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user.getUserDetails());
        entityManager.remove(user);
    }

}
