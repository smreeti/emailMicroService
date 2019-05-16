package com.smriti.adminservice.service;

import com.smriti.adminservice.requestDTO.AdminRequestDTO;
import com.smriti.adminservice.responseDTO.AdminResponseDTO;

import java.util.List;

public interface AdminService {

    void saveAdmin(AdminRequestDTO requestDTO);

    List<AdminResponseDTO> adminsToSendEmails();
}
