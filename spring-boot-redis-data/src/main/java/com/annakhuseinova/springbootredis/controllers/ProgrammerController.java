package com.annakhuseinova.springbootredis.controllers;

import com.annakhuseinova.springbootredis.model.Programmer;
import com.annakhuseinova.springbootredis.services.ProgrammerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProgrammerController {

    @Autowired
    private ProgrammerService programmerService;

    @PostMapping(value = "/programmer-string")
    public void addProgrammer(@RequestBody Programmer programmer) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        programmerService
                .setProgrammerAsString(String.valueOf(programmer.getId()), objectMapper.writeValueAsString(programmer));
    }

    @GetMapping(value = "/programmer-string/{id}")
    public String getProgrammerByKey(@PathVariable String id){

        return programmerService.getProgrammerAsString(id);
    }
}
