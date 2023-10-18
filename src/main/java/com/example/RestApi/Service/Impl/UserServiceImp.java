package com.example.RestApi.Service.Impl;

import com.example.RestApi.Entity.User;
import com.example.RestApi.Repository.UserRepo;
import com.example.RestApi.Service.Interface.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepo userRepo;


    // save one
    @Override
    public User save(User user) {
        userRepo.save(user);
        return user;
    }
    public List<User> saveAll(List<User> users) {
         userRepo.saveAll(users);

        return users;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getById(int id) {
     return  userRepo.findById(id);
    }

    @Override
    public void deleteUserById(int id) {
        userRepo.deleteById(id);
    }
    @Override
    public void deleteAllUser()
    {
        userRepo.deleteAll();
    }

    @Override
    public List<User> getUserByName(String firstname, String lastname) {
       return userRepo.findByFirstnameAndLastname(firstname,lastname);
    }


    public boolean updateUser(int id, String firstname) {
        Optional<User> optionalUser = userRepo.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstname(firstname);
            userRepo.save(user);

            return true;
        } else {
            return false;
        }
    }



}


