package com.example.RestApi.Service.Interface;

import com.example.RestApi.Entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    // save one user
    User save(User user);
    // save list of user
    List<User> saveAll(List<User> users);
    // get all users
    List<User> getAllUsers();

    Optional<User> getById(int id);
    void  deleteUserById(int id);
    void  deleteAllUser();
    List<User>  getUserByName(String firstname,String lastname);
    boolean updateUser(int id,String firstname);
}


