package com.annakhuseinova.springbootredis.repos;

import com.annakhuseinova.springbootredis.model.Programmer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProgrammerRepository {


    // String operations
    void setProgrammerAsString(String idKey, String programmer);

    String getProgrammerAsString(String idKey);


    // List operations
    void addProgrammerToProgrammerList(Programmer programmer);

    List<Programmer> getProgrammerListMembers();

    Long getProgrammerListCount();

    // Set operations.

    void addProgrammerToSet(Programmer ... programmers);

    Set<Programmer> getProgrammersSetMembers();

    boolean isSetMember(Programmer programmer);

    // Hash

    void saveHash(Programmer programmer);

    void updateHash(Programmer programmer);

    Map<Integer, Programmer> findAllHashes();

    Programmer findInHash(int id);

    void deleteHash(int id);

}
