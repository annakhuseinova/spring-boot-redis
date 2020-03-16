package com.annakhuseinova.springbootredis.config;

import com.annakhuseinova.springbootredis.model.Programmer;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;

@Configuration
public class SpringConfiguration {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("{spring.redis.jedis.pool.max-active}")
    private int maxTotal;

    @Value("{spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("{spring.redis.jedis.pool.min-idle}")
    private int minIdle;

    /**  1. Create jedis client with pool configuration
     * */

    @Bean
    public JedisClientConfiguration jedisClientConfiguration(){

        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder
                jedisPoolingClientConfigurationBuilder =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder)
                        JedisClientConfiguration.builder();
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxTotal(maxTotal);
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMinIdle(minIdle);
        return jedisPoolingClientConfigurationBuilder.poolConfig(genericObjectPoolConfig).build();
    }


    /**  2. Create jedis connection factory.
     * */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setPort(port);
        if (!StringUtils.isEmpty(password)){
            redisStandaloneConfiguration.setPassword(password);
        }
        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration());
    }

    /**  3. Create RedisTemplate. By default, uses Java serialization for its objects using
     *  JDKSerializationRedisSerializer.
     * */
    @Bean
    public RedisTemplate redisTemplate(){

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer()); // Устанавливаем StringRedisSerializer для ключа.
        return redisTemplate;

    }

    @Bean
    @Qualifier("listOperations")
    public ListOperations<String, Programmer> listOperations(RedisTemplate<String, Programmer> redisTemplate){

       return redisTemplate.opsForList();
    }

    @Bean
    public SetOperations<String, Programmer> setOperations(){

        return redisTemplate().opsForSet();
    }

}
