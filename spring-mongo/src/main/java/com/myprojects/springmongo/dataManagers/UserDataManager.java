package com.myprojects.springmongo.dataManagers;

import com.myprojects.springmongo.models.UserEntity;
import com.myprojects.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDataManager {

    @Autowired
    private UserRepository userRepository;

    public String removeUserById(String userId) {
        if (userId.isBlank() || userRepository.findById(userId).isEmpty()) {
            return null;
        } else {
            userRepository.deleteById(userId);
            return "user successfully deleted";
        }
    }

    public String addUser(UserEntity user) {
        if (userRepository.findAll().stream().map(UserEntity::getPassportId).equals(user.getPassportId())) {
            return null;
        } else {
            return "The user successfully added";
        }
    }
}
