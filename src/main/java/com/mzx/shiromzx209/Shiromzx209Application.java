package com.mzx.shiromzx209;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@MapperScan("com.mzx.shiromzx209.dao")
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class Shiromzx209Application {

    public static void main(String[] args) {
        SpringApplication.run(Shiromzx209Application.class, args);
    }

}
