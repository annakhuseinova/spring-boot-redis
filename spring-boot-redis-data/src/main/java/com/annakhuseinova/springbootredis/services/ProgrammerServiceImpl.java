package com.annakhuseinova.springbootredis.services;

import com.annakhuseinova.springbootredis.repos.ProgrammerRepository;
import org.springframework.stereotype.Service;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {

    private ProgrammerRepository programmerRepository;

    public ProgrammerServiceImpl(ProgrammerRepository programmerRepository) {
        this.programmerRepository = programmerRepository;
    }

    @Override
    public void setProgrammerAsString(String idKey, String programmer) {
        programmerRepository.setProgrammerAsString(idKey, programmer);
    }

    @Override
    public String getProgrammerAsString(String key) {
        return programmerRepository.getProgrammerAsString(key);
    }
}
