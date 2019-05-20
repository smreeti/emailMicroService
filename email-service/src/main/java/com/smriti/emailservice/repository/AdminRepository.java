package com.smriti.emailservice.repository;

import com.smriti.emailservice.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("SELECT a FROM Admin a WHERE a.id=:id")
    Admin findAdminById(@Param("id") Long id);
}
