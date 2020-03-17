package com.annakhuseinova.springbootredis.controllers;

import com.annakhuseinova.springbootredis.model.Programmer;
import com.annakhuseinova.springbootredis.services.ProgrammerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @PostMapping(value = "/programmers-list")
    public void addProgrammerToList(@RequestBody Programmer programmer){

        programmerService.addProgrammerToList(programmer);
    }

    @GetMapping(value = "/programmers-list")
    public List<Programmer> getProgrammerListMembers(){

        return programmerService.getProgrammerListMembers();
    }

    @GetMapping(value = "/programmers-list/count")
    public Long getProgrammerListCount(){

        return programmerService.getProgrammersListCount();
    }

    @PostMapping
    public void addProgrammerToProgrammerSet(@RequestBody Programmer ... programmers){

        programmerService.addToProgrammerSet(programmers);
    }

    @GetMapping(name = "/programmers-set")
    public Set<Programmer> getProgrammersSetMembers(){

        return programmerService.getProgrammersSetMembers();
    }

    @PostMapping(value = "/programmers-set/member")
    public boolean isSetMember(@RequestBody Programmer programmer){

        return programmerService.isSetMember(programmer);
    }

    @PostMapping("/programmers-hash")
    public void saveHash(@RequestBody Programmer programmer){

        programmerService.saveHash(programmer);
    }

    @PutMapping(value = "/programmers-hash")
    public void updateHash(@RequestBody Programmer programmer){

        programmerService.updateHash(programmer);
    }

    @GetMapping(value = "/programmers-hash/{id}")
    public Programmer findInHash(@PathVariable int id){

        return programmerService.findInHash(id);
    }

    @DeleteMapping(value = "/programmers-hash/{id}")
    public void deleteHash(@PathVariable int id){

        programmerService.deleteHash(id);
    }

}
