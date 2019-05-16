package com.smriti.adminservice.controller;

import com.smriti.adminservice.entities.Admin;
import com.smriti.adminservice.requestDTO.AdminRequestDTO;
import com.smriti.adminservice.responseDTO.AdminResponseDTO;
import com.smriti.adminservice.responseDTO.SuccessResponseDTO;
import com.smriti.adminservice.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add")
    public ResponseEntity<SuccessResponseDTO> addAdmin(@RequestBody AdminRequestDTO requestDTO) {
        adminService.saveAdmin(requestDTO);
        return new ResponseEntity<>(new SuccessResponseDTO("Admin created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/admins")
    public ResponseEntity<List<AdminResponseDTO>> getAdminsToSendEmail() {
        return new ResponseEntity<>(adminService.adminsToSendEmails(), HttpStatus.OK);
    }
}
