package com.smriti.adminservice.utility;

import com.smriti.adminservice.responseDTO.AdminResponseDTO;

import java.util.function.Function;

public class AdminUtils {

    public static Function<Object[], AdminResponseDTO> convertToResponse = (object) -> {
        final Integer ADMIN_ID = 0;
        final Integer EMAIL_ADDRESS_INDEX = 1;

        return AdminResponseDTO.builder()
                .id(Long.parseLong(object[ADMIN_ID].toString()))
                .emailAddress(object[EMAIL_ADDRESS_INDEX].toString())
                .build();
    };
}
