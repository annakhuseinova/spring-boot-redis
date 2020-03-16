package com.annakhuseinova.springbootredis.repos;

import com.annakhuseinova.springbootredis.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class ProgrammerRepositoryImpl implements ProgrammerRepository {

    private static final String REDIS_LIST_KEY = "ProgrammerList";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void setProgrammerAsString(String idKey, String programmer) {
        redisTemplate.opsForValue().set(idKey, programmer);
        redisTemplate.expire(idKey, 10, TimeUnit.SECONDS); // To expire the value of the idKey in 10 seconds.
    }

    @Override
    public String getProgrammerAsString(String idKey) {
        return (String) redisTemplate.opsForValue().get(idKey);
    }

    @Override
    public void addProgrammerToProgrammerList(Programmer programmer) {
        redisTemplate.opsForList().leftPush(REDIS_LIST_KEY, programmer);
    }

    @Override
    public List<Programmer> getProgrammerListMembers() {
        return null;
    }

    @Override
    public Long getProgrammerListCount() {
        return null;
    }
}
