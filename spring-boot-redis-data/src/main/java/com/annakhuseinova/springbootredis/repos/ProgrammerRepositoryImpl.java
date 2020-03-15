package com.annakhuseinova.springbootredis.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class ProgrammerRepositoryImpl implements ProgrammerRepository {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void setProgrammerAsString(String idKey, String programmer) {

    }

    @Override
    public String getProgrammerAsString(String idKey) {
        return null;
    }
}
