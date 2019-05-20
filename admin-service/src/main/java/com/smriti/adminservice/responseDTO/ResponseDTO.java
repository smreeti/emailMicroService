package com.smriti.adminservice.responseDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseDTO {
    private List<AdminResponseDTO> adminResponseDTOS;

    private String message;
}
