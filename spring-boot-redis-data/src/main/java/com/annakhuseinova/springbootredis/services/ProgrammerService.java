package com.annakhuseinova.springbootredis.services;

public interface ProgrammerService {


    void setProgrammerAsString(String idKey, String programmer);

    String getProgrammerAsString(String key);
}
