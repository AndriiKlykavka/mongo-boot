package com.myprojects.springmongo.controllers;

import com.myprojects.springmongo.dataManagers.UserDataManager;
import com.myprojects.springmongo.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDataManager userDataManager;

    @GetMapping("/users")
    public List<UserEntity> getUsers() {
        return userDataManager.getUsers();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = "text/plain")
    public String removeUser(@RequestParam String userId){
        return userDataManager.removeUserById(userId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public String addUser(@RequestBody UserEntity user){
        return userDataManager.addUser(user);
    }
}
