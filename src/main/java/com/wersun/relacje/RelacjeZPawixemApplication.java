package com.wersun.relacje;

import com.wersun.relacje.Dao.UserDao;
import com.wersun.relacje.Dao.UserDetailsDao;
import com.wersun.relacje.model.User;
import com.wersun.relacje.model.UserDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RelacjeZPawixemApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(RelacjeZPawixemApplication.class, args);
        UserDao userDao = context.getBean(UserDao.class);
        UserDetailsDao userDetailsDao = context.getBean(UserDetailsDao.class);

        User user = new User("wersun","haslo","pawix10@gmail.com");
        UserDetails userDetails = new UserDetails("pawel", "wronski", "poznan");
        user.setUserDetails(userDetails);

        userDao.create(user);
//        User foundUser = userDao.read(1L);
//        System.out.println(foundUser.toString());
//
//        user.setEmail("innymail");
//        userDao.update(user);
//        foundUser = userDao.read(1L);
//
//        System.out.println(foundUser.toString());
//
//        userDao.delete(1L);
//
        UserDetails foundDetails = userDetailsDao.read(1L);
        User foundUser = foundDetails.getUser();

        System.out.println(foundUser.toString());

        context.close();//nie trzeba ale warto
    }
}
