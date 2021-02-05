package com.mvc.ecommerce.controller;

import com.mvc.ecommerce.controller.RequestPojo.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/addtocart")
public class AddtoCartController {

    @RequestMapping("status")
    public ResponseEntity<?> serverStatus() {
        return new ResponseEntity<>(new ApiResponse("Server is running.", ""), HttpStatus.OK);
    }
}
