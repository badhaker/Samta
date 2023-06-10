package com.samta.repository;

import com.samta.entity.Management;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagementRepository extends JpaRepository<Management,Long> {

    @Query(value = "Select * from user where email =:email",nativeQuery = true)
    Management findByEmail(String email);

}
