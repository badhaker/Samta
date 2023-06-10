package com.samta.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role_mst")
public class Role extends BaseEntity{
    private String roleName;

}
