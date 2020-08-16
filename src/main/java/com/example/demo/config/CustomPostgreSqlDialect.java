package com.example.demo.config;

import org.hibernate.dialect.PostgreSQL10Dialect;

import java.sql.Types;

/**
 * 自定义SQL方言用来拓展jsonb类型与Map互相转换
 * @author Zhai
 * 2020/8/17 1:17
 */

public class CustomPostgreSqlDialect extends PostgreSQL10Dialect {

    public CustomPostgreSqlDialect() {
        super();
        registerColumnType(Types.JAVA_OBJECT, "jsonb");
    }
}
