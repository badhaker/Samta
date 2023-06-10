package com.samta.service.serviceImpl;

import com.samta.SecutrityConfig.UserEntity;
import com.samta.entity.Products;
import com.samta.repository.ProductRepository;
import com.samta.repository.UserRepository;
import com.samta.request.CreateUser;
import com.samta.service.UserService;
import com.samta.service.response.AllDetailsProduct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public String createUser(CreateUser createUser) {
        UserEntity userEntity = UserEntity.builder()
                .firstName(createUser.getFirstName())
                .lastName(createUser.getLastName())
                .email(createUser.getEmail())
                .password(createUser.getPassword())
                .build();
        userRepository.save(userEntity);
        return "User Created...";
    }

    public String loginUser(String email, String password) {
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(null);
        if(userEntity.getEmail() == email && userEntity.getPassword() == password){

            return "User Login";
        }else {
            return "Login Failed";
        }

    }
    @Override
    public List<AllDetailsProduct> getAllDetails()  {
        List<Products> products = productRepository.findAll();
        return products.stream().map(this::getproductList).collect(Collectors.toList());

    }
    private AllDetailsProduct getproductList(Products products) {
        return AllDetailsProduct.builder()
                .price(products.getPrice())
                .type(products.getType())
                .available(products.getAvailable())
                .manufacturer(products.getManufacturer())
                .productName(products.getProductName())
                .build();
    }

}
