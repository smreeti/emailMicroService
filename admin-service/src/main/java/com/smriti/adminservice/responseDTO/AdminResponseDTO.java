package com.smriti.adminservice.responseDTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponseDTO {

    private String emailAddress;

    private Long id;
}
