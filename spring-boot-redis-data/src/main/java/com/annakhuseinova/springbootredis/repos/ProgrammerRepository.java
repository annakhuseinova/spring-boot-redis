package com.annakhuseinova.springbootredis.repos;

import com.annakhuseinova.springbootredis.model.Programmer;

import java.util.List;

public interface ProgrammerRepository {

    void setProgrammerAsString(String idKey, String programmer);

    String getProgrammerAsString(String idKey);

    void addProgrammerToProgrammerList(Programmer programmer);

    List<Programmer> getProgrammerListMembers();

    Long getProgrammerListCount();
}
