package com.smriti.emailservice.service.serviceImpl;

import com.smriti.emailservice.entities.Admin;
import com.smriti.emailservice.repository.AdminRepository;
import com.smriti.emailservice.responseDTO.AdminResponseDTO;
import com.smriti.emailservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void updateAdmin(AdminResponseDTO adminResponseDTO) {
        Admin admin = findAdminById(adminResponseDTO);
        admin.setEmailSent('Y');
        adminRepository.save(admin);
    }

    public Admin findAdminById(AdminResponseDTO adminResponseDTO) {
        return adminRepository.findAdminById(adminResponseDTO.getId());

    }
}
