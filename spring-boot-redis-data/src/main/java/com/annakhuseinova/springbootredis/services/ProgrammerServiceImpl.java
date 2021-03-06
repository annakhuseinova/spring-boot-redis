package com.annakhuseinova.springbootredis.services;

import com.annakhuseinova.springbootredis.model.Programmer;
import com.annakhuseinova.springbootredis.repos.ProgrammerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

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


    // List operations

    @Override
    public void addProgrammerToList(Programmer programmer) {

        programmerRepository.addProgrammerToProgrammerList(programmer);
    }

    @Override
    public List<Programmer> getProgrammerListMembers() {
        return programmerRepository.getProgrammerListMembers();
    }

    @Override
    public Long getProgrammersListCount() {
        return programmerRepository.getProgrammerListCount();
    }

    // Set operations

    @Override
    public void addToProgrammerSet(Programmer... programmers) {
        programmerRepository.addProgrammerToSet(programmers);
    }

    @Override
    public Set<Programmer> getProgrammersSetMembers() {
        return programmerRepository.getProgrammersSetMembers();
    }

    @Override
    public boolean isSetMember(Programmer programmer) {
        return programmerRepository.isSetMember(programmer);
    }

    // Hash operations

    @Override
    public void saveHash(Programmer programmer) {

        programmerRepository.saveHash(programmer);
    }

    @Override
    public void updateHash(Programmer programmer) {

        programmerRepository.updateHash(programmer);
    }

    @Override
    public Map<Integer, Programmer> findAllHash() {
        return programmerRepository.findAllHashes();
    }

    @Override
    public Programmer findInHash(int id) {
        return programmerRepository.findInHash(id);
    }

    @Override
    public void deleteHash(int id) {

        programmerRepository.deleteHash(id);
    }
}
