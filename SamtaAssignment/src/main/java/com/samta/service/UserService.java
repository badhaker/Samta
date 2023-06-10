package com.samta.service;

import com.samta.request.CreateUser;
import com.samta.service.response.AllDetailsProduct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    public String createUser(CreateUser createUser);

    String loginUser(String email, String password);
    List<AllDetailsProduct> getAllDetails();
}
