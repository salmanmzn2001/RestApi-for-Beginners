package com.example.RestApi.Controller;

import com.example.RestApi.Entity.User;
import com.example.RestApi.Repository.UserRepo;
import com.example.RestApi.Service.Impl.UserServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class Controller {
    @Autowired
    UserServiceImp userService;
    @Autowired
    UserRepo userRepo;
    List<User> list;

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        log.info("user {}", user);

        return userService.save(user);

    }

    @GetMapping("/hello")
    public String hello() {
        return "salman";
    }

    @PostMapping("/saveuser")
    public User save(@RequestBody User user) {
        log.info("user {}", user);
        return userService.save(user);
    }

    @PostMapping("/alluser")
    public List<User> savelist(@RequestBody List<User> users) {
        List<User> list = userService.saveAll(users);
        return list;
    }

    @GetMapping("/getall")
    public List<User> getuser() {
        List<User> list1 = userService.getAllUsers();
        return list1;
    }

    @GetMapping("/getByName/{firstname}/{lastname}")
    public List<User> getByName(@PathVariable String firstname, @PathVariable String lastname) {
        log.info("firstname {}, lastname {}", firstname, lastname);
        List<User> list1 = userService.getUserByName(firstname, lastname);
        return list1;
    }

    @GetMapping("/getById/{id}")
    public Optional<User> getuser(@PathVariable int id) {
        return userService.getById(id);

    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        log.info("Successfully Deleted user Id: {}", id);
        userService.deleteUserById(id);

    }

    @DeleteMapping("/deleteAllUser")
    public ResponseEntity<String> deleteAllUser() {
        userService.deleteAllUser();
        return ResponseEntity.ok("All users have been deleted.");
    }
//    @PutMapping("/updateUser/{id}/{firstname}")
//    public ResponseEntity<String> updateUser(@PathVariable int id,@PathVariable String firstname) {
//        userService.updateUser(id,firstname);
//        return ResponseEntity.ok("All users have been updated.");
//    }

    @PutMapping("/updateUser/{id}/{firstname}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @PathVariable String firstname) {
        log.info("id {}, firstname{}", id, firstname);

        boolean isUpdateSuccessful = userService.updateUser(id, firstname);

        if (isUpdateSuccessful) {
            return ResponseEntity.ok("User with ID " + id + " has been updated with firstname " + firstname + ".");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + id + " not found.");
        }
    }

}
