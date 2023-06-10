package com.samta.service;

import com.samta.request.CreateOutlet;
import com.samta.request.CreateProduct;
import com.samta.request.LoginUserRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public interface ManagementService {

    String login(LoginUserRequest loginUserRequest);

    String createOutlets(CreateOutlet createOutlet);
    String createProducts(CreateProduct createProduct);

    String soldProduct(Long roleId, Long productId,String sold);
    String uploadFile(MultipartFile file) throws IOException;
}
