package com.samta.controller;

import com.samta.request.CreateUser;
import com.samta.request.LoginUserRequest;
import com.samta.service.UserService;
import com.samta.service.response.AllDetailsProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/createUser")
    public String createUser(@RequestBody CreateUser createUser) {
        return userService.createUser(createUser);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        return userService.loginUser(email,password);
    }


    @GetMapping("/all")
    public List<AllDetailsProduct> allProduct() {
        return userService.getAllDetails();
    }


}
