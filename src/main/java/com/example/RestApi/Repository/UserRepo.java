package com.example.RestApi.Repository;

import com.example.RestApi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepo extends JpaRepository<User,Integer> {
List<User> findByFirstnameAndLastname(String firstname,String lastname);

    void save(String firstname);
}