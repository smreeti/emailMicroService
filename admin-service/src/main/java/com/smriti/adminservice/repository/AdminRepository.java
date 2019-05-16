package com.smriti.adminservice.repository;

import com.smriti.adminservice.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
