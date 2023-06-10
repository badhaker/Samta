package com.samta.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "management")
public class Management extends BaseEntity{
    private String name;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
}
