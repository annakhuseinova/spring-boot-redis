package com.annakhuseinova.springbootredis.repos;

import com.annakhuseinova.springbootredis.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class ProgrammerRepositoryImpl implements ProgrammerRepository {

    private static final String REDIS_LIST_KEY = "ProgrammerList";
    private static final String REDIS_SET_KEY = "ProgrammerSet";

    @Autowired
    private ListOperations<String,Programmer> listOperations;

    @Autowired
    private SetOperations<String, Programmer> setOperations;

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


    // List operations

    @Override
    public void addProgrammerToProgrammerList(Programmer programmer) {
        listOperations.leftPush(REDIS_LIST_KEY, programmer);

    }

    @Override
    public List<Programmer> getProgrammerListMembers() {
        return listOperations.range(REDIS_LIST_KEY, 0,-1);
    }

    @Override
    public Long getProgrammerListCount() {
        return listOperations.size(REDIS_LIST_KEY);
    }


    // Set operations

    @Override
    public void addProgrammerToSet(Programmer... programmers) {

        setOperations.add(REDIS_SET_KEY, programmers);
    }

    @Override
    public Set<Programmer> getProgrammersSetMembers() {
        return setOperations.members(REDIS_SET_KEY);
    }

    @Override
    public boolean isSetMember(Programmer programmer) {
        return setOperations.isMember(REDIS_SET_KEY, programmer);
    }
}
