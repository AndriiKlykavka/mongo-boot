package com.myprojects.springmongo.controllers;

import com.myprojects.springmongo.dataManagers.UserDataManager;
import com.myprojects.springmongo.models.UserEntity;
import com.myprojects.springmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = "text/plain")
    public String removeUser(@RequestParam String userId){
        return userService.removeUserById(userId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public String addUser(@RequestBody UserEntity user){
        return userService.addUser(user);
    }
}
