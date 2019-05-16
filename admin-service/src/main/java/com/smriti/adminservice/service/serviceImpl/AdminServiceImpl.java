package com.smriti.adminservice.service.serviceImpl;

import com.smriti.adminservice.entities.Admin;
import com.smriti.adminservice.repository.AdminRepository;
import com.smriti.adminservice.requestDTO.AdminRequestDTO;
import com.smriti.adminservice.service.AdminService;
import com.smriti.adminservice.utility.MapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void saveAdmin(AdminRequestDTO requestDTO) {
        Admin admin = MapperUtility.map(requestDTO, Admin.class);
        adminRepository.save(admin);
    }
}
