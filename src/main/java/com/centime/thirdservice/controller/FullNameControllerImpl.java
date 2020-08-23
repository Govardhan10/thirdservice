package com.centime.thirdservice.controller;

import com.centime.thirdservice.model.NameDetails;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FullNameControllerImpl implements FullNameController{

    @Qualifier("eurekaClient")
    @Lazy
    @Autowired
    EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Override
    public ResponseEntity<String> getFullName(NameDetails nameDetails) {
        log.info("Service name : {} , endpoint : /fullname",eurekaClient.getApplication(appName).getName());
        log.info("Name details payload : {}",nameDetails.toString());
        return ResponseEntity.ok().body(nameDetails.toString());
    }
}
