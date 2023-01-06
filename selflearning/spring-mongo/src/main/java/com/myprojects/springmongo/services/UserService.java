package com.myprojects.springmongo.services;

import com.myprojects.springmongo.dataManagers.UserDataManager;
import com.myprojects.springmongo.models.UserEntity;
import com.myprojects.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDataManager userDataManager;
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public String removeUserById(String userId){
        String removeStatus = userDataManager.removeUserById(userId);
        if(removeStatus == null){
            return "The user doesn't exist or userId is wrong";
        }
        return removeStatus;
    }

    public String addUser(UserEntity user){
        String addStatus = userDataManager.addUser(user);
        if(addStatus == null){
            return "The user with such passport ID already exists";
        }
        return addStatus;
    }
}
