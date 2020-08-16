package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * 自定义获取Auditor用来给@CreateBy与@LastModifiedBy赋值
 * @author Zhai
 * 2020/8/17 1:00
 */
@Configuration
public class UserAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // if your wang to get userInfo, for example SecurityContext.getXXX()..... you can use Optional.ofNullable(...)
        return Optional.of("admin");
    }
}
