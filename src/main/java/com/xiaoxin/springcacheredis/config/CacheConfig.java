package com.xiaoxin.springcacheredis.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lx
 * @date 2020/12/18
 */
@Configuration
@EnableCaching
public class CacheConfig {

    @Bean("empKeyGenerator")
    public KeyGenerator keyGenerator() {
        return (o, method, objects) -> objects[0] + "";
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory factory) {
        return RedisCacheManager.builder(factory)
                .cacheDefaults(defaultCacheConfig(20))
                .withInitialCacheConfigurations(initCacheConfigMap())
                .transactionAware()
                .build();
    }

    private RedisCacheConfiguration defaultCacheConfig(Integer second) {
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(second))
                .serializeKeysWith(RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(serializer))
                .disableCachingNullValues();
    }

    private Map<String, RedisCacheConfiguration> initCacheConfigMap() {
        Map<String, RedisCacheConfiguration> map = new HashMap<>(16);
        map.put("emp", this.defaultCacheConfig(100));
        map.put("emp-hot", this.defaultCacheConfig(1000));
        map.put("dep", this.defaultCacheConfig(1000));
        return map;
    }

}
