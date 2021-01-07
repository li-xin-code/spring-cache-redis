package com.xiaoxin.springcacheredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lx
 */
@SpringBootApplication
@MapperScan("com.xiaoxin.springcacheredis.mapper")
public class SpringCacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCacheRedisApplication.class, args);
    }

}
