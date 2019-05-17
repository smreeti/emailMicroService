package com.smriti.emailservice.responseDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseDTO {
    private List<AdminResponseDTO> adminResponseDTOS;
}
