package com.myprojects.springmongo.dataManagers;

import com.myprojects.springmongo.models.UserEntity;
import com.myprojects.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Service
public class UserDataManager {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public String removeUserById(String userId){
        if(userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return "User successfully deleted";
        } else{
            return "The user doesn't exist";
        }
    }

    public String addUser(UserEntity user){
        if (userRepository.findAll().contains(user)) {
            return "The user already exists";
        } else {
            userRepository.save(user);
            return "User successfully saved";
        }
    }
}
