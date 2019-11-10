package com.example.experi.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@ConfigurationProperties(prefix = "spring.mongodb")
public class Mongo1Config extends AbstractMongoConfig {

    @Bean(name = "mongo1")
    @Primary
    @Override
    public MongoTemplate getMongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}
