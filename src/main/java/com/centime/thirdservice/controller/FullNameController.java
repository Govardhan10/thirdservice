package com.centime.thirdservice.controller;

import com.centime.thirdservice.model.NameDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api("Full Name Controller")
public interface FullNameController {

    @ApiOperation("End point to get full name")
    @PostMapping(value = "/fullname",consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getFullName(@Valid @RequestBody(required = true)NameDetails nameDetails);

}
