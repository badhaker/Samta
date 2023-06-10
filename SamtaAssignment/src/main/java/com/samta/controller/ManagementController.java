package com.samta.controller;

import com.samta.request.CreateOutlet;
import com.samta.request.CreateProduct;
import com.samta.request.LoginUserRequest;
import com.samta.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ManagementController {

    @Autowired
    ManagementService managementService;


    @PostMapping("/login")
    public String createUser(@RequestBody LoginUserRequest loginUserRequest) {
        return managementService.login(loginUserRequest);
    }

    @PostMapping("/oulets")
    public String createOutlets(@RequestBody CreateOutlet createOutlet) {
        return managementService.createOutlets(createOutlet);
    }

    @PostMapping("/product")
    public String createProducts(@RequestBody CreateProduct createProduct) {
        return managementService.createProducts(createProduct);
    }

    @PostMapping("/productsold")
    public String soldProducts(@RequestParam Long roleId,@RequestParam Long productId,@RequestParam String sold) {
        return managementService.soldProduct(roleId,productId,sold);
    }

    @PostMapping("/uploadcsv")
    public String uploadProducts(@RequestParam MultipartFile file) throws IOException {
        return managementService.uploadFile(file);
    }
}
