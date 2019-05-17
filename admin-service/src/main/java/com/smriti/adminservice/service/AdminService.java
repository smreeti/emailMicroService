package com.smriti.adminservice.service;

import com.smriti.adminservice.requestDTO.AdminRequestDTO;
import com.smriti.adminservice.responseDTO.ResponseDTO;

public interface AdminService {

    void saveAdmin(AdminRequestDTO requestDTO);

    ResponseDTO adminsToSendEmails();
}
