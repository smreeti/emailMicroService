package com.smriti.adminservice.service.serviceImpl;

import com.smriti.adminservice.entities.Admin;
import com.smriti.adminservice.repository.AdminRepository;
import com.smriti.adminservice.requestDTO.AdminRequestDTO;
import com.smriti.adminservice.responseDTO.AdminResponseDTO;
import com.smriti.adminservice.responseDTO.ResponseDTO;
import com.smriti.adminservice.service.AdminService;
import com.smriti.adminservice.utility.AdminQueryCreator;
import com.smriti.adminservice.utility.AdminUtils;
import com.smriti.adminservice.utility.MapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveAdmin(AdminRequestDTO requestDTO) {
        Admin admin = MapperUtility.map(requestDTO, Admin.class);
        adminRepository.save(admin);
    }

    @Override
    public ResponseDTO adminsToSendEmails() {

        List<Object[]> results = entityManager.createNativeQuery(
                AdminQueryCreator.createQueryToFetchAdminsToSendEmail.get()).getResultList();

        List<AdminResponseDTO> responseDTOS = results.stream().map(AdminUtils.convertToResponse)
                .collect(Collectors.toList());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setAdminResponseDTOS(responseDTOS);

        return responseDTO;
    }
}
