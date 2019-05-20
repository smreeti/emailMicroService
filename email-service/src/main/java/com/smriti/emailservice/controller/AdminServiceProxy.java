package com.smriti.emailservice.controller;

import com.smriti.emailservice.responseDTO.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "AdminService")
@Component
public interface AdminServiceProxy {

    @RequestMapping("/api/admins")
    ResponseDTO getAdminsToSendEmail();

    @RequestMapping("/api/sayHello/{name}")
    ResponseDTO sayHello(@PathVariable("name")String name);

}


