package com.samta.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProduct {
    private String productName;
    private String type;
    private String manufacturer;
    private String price;
    private String available;
    private Long roleId;
}
