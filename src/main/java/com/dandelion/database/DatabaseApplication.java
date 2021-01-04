package com.dandelion.database;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 数据库路操作启动类
 * @author dandelion
 * @date 2021
 */

@MapperScan("com.dandelion.database.service.mybatis.mapper")
@SpringBootApplication
public class DatabaseApplication {

    public static void main(String[] args) {

        args = new String[]{"mybatis-anno","ageLarger"};
        SpringApplication.run(DatabaseApplication.class, args);
    }

}
