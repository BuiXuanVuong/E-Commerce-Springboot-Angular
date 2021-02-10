package com.mvc.ecommerce.controller;

import com.mvc.ecommerce.controller.RequestPojo.ApiResponse;
import com.mvc.ecommerce.controller.RequestPojo.LoginRequest;
import com.mvc.ecommerce.model.User;
import com.mvc.ecommerce.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("api/signup")
public class SignUpController {

    @Autowired
    UserService userService;

    @RequestMapping("user")
    public ResponseEntity<?> userLogin(@RequestBody HashMap<String, String> signupRequest) {
        try {
            JSONObject obj = new JSONObject();
            User user = userService.signUpUser(signupRequest);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(),""));
        }
    }
}
