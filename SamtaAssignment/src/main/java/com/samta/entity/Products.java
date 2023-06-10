package com.samta.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Products extends BaseEntity{
    private String productName;
    private String type;
    private String manufacturer;
    private String price;

    private String available;
    private String sold;

    @ManyToOne
    @JoinColumn(name = "outlet_id")
    private Outlets outlets;
}
