package com.samta.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "outlets")
public class Outlets extends BaseEntity{
    private String outletName;
     private String location;
     private String email;
     private String phone;

     @OneToMany(mappedBy = "outlets")
     private Products products;

}
