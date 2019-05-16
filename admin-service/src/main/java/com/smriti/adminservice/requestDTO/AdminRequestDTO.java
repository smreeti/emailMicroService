package com.smriti.adminservice.requestDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRequestDTO {

    private String user;

    private String emailAddress;

    private Character emailSent;
}
