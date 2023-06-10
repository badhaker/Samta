package com.samta.service.serviceImpl;

import com.samta.entity.Outlets;
import com.samta.entity.Products;
import com.samta.entity.Management;
import com.samta.repository.OutletRepository;
import com.samta.repository.ProductRepository;
import com.samta.repository.ManagementRepository;
import com.samta.request.CreateOutlet;
import com.samta.request.CreateProduct;
import com.samta.request.LoginUserRequest;
import com.samta.service.ManagementService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

@Service
public class ManagementServiceImpl implements ManagementService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ManagementRepository userRepository;
    @Autowired
    OutletRepository outletRepository;

    @Override
    public String login(LoginUserRequest loginUserRequest) {
        Management user = userRepository.findByEmail(loginUserRequest.getEmail());

        if (user != null && user.getPassword().equals(loginUserRequest.getPassword())) {
            if (user.getRole().getId() == loginUserRequest.getRoleId()) {
                return "You are login as admin";
            } else if (user.getRole().getId() == loginUserRequest.getRoleId()) {
                return "You are login as supervisor";
            } else if (user.getRole().getId() == loginUserRequest.getRoleId()) {
                return "You are login as sales-person";
            }
        }
        // Invalid username or password
        return "Invalid Credentials";
    }

    @Override
    public String createOutlets(CreateOutlet createOutlet) {
        Outlets outlets = null;
        if (createOutlet.getRoleId() != 1) {
            return "Not Authorized";
        } else {
            outlets = Outlets.builder()
                    .outletName(createOutlet.getOutletName())
                    .email(createOutlet.getEmail())
                    .phone(createOutlet.getPhone())
                    .location(createOutlet.getLocation())
                    .build();
            outletRepository.save(outlets);
            return "Outlets Created";
        }
    }

    @Override
    public String createProducts(CreateProduct createProduct) {
        Products products = null;
        if (createProduct.getRoleId() != 2) {
            return "Not Authorized";
        } else {
            products = Products.builder()
                    .productName(createProduct.getProductName())
                    .type(createProduct.getType())
                    .manufacturer(createProduct.getManufacturer())
                    .price(createProduct.getPrice())
                    .available(createProduct.getAvailable())
                    .build();
            productRepository.save(products);
            return "product Updated";
        }
    }

    @Override
    public String soldProduct(Long roleId, Long productId,String sold) {
        Products products = productRepository.findById(productId).orElse(null);
        products.setSold(sold);
        productRepository.save(products);
        return "sold units updated";
    }

    public String uploadFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            // Handle empty file case
            return "redirect:/?error=empty";
        }

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord record : records) {
                String name = record.get("name");
                 String productName = record.get("productName");
                 String type = record.get("type");
                 String manufacturer = record.get("manufacturer");
                 String price = record.get("price");
                 String available = record.get("available");

                Products products = new Products();
                products.setProductName(productName);
                products.setType(type);
                products.setManufacturer(manufacturer);
                products.setPrice(price);
                products.setAvailable(available);
                productRepository.save(products);
            }
        } catch (Exception e) {
            // Handle exception case
            return "Upload Failed";
        }
        return "Upload Success";
    }
}
