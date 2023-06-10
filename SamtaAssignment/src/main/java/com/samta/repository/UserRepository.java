package com.samta.repository;


import com.samta.SecutrityConfig.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
//    @Query(value = "select * from user where email = :email",nativeQuery = true)
    Optional<UserEntity> findByEmail(String email);
}
