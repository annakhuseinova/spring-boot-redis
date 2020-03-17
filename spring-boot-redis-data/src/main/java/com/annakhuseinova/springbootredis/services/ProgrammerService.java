package com.annakhuseinova.springbootredis.services;

import com.annakhuseinova.springbootredis.model.Programmer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProgrammerService {


    void setProgrammerAsString(String idKey, String programmer);

    String getProgrammerAsString(String key);

    // Strings

    void addProgrammerToList(Programmer programmer);

    List<Programmer> getProgrammerListMembers();

    Long getProgrammersListCount();

    // Sets

    void addToProgrammerSet(Programmer ... programmers);

    Set<Programmer> getProgrammersSetMembers();

    boolean isSetMember(Programmer programmer);

    // Hashes

    void saveHash(Programmer programmer);

    void updateHash(Programmer programmer);

    Map<Integer, Programmer> findAllHash();

    Programmer findInHash(int id);

    void deleteHash(int id);

}
