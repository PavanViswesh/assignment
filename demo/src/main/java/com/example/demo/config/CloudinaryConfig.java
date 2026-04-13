package com.example.demo.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dde2caymp",
                "api_key", "611814948477989",
                "api_secret", "bNirdzw5mza5qfQZddBbjm7ea3w"
        ));
    }
}