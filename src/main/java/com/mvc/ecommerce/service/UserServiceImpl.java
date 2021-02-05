package com.mvc.ecommerce.service;

import com.mvc.ecommerce.Repository.UserRepository;
import com.mvc.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepo;

    @Override
    public User findByMobile(String mobile) throws Exception {
        return userRepo.findByMobile(mobile).orElseThrow(()-> new Exception("User not found...")) ;
    }

    @Override
    public User getUserDetailById(long userId) throws Exception {
        return userRepo.findById(userId).orElseThrow(()-> new Exception("User not found..."));
    }

    @Override
    public User signUpUser(HashMap<String, String> signupRequest) throws Exception {
        try {
            if(userRepo.findByMobile(signupRequest.get("mobile")).isPresent()) {
                throw new Exception("user is already registered with Mobile No.");
            }
            User user = new User();
            user.setName(signupRequest.get("name"));
            user.setEmail(signupRequest.get("email"));
            user.setMobile(signupRequest.get("mobile"));
            user.setPassword(signupRequest.get("password"));
            userRepo.save(user);
            return user;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
