package com.ltz.emplInfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ltz.emplInfo.*.mapper") // 扫描Mapper接口
public class EmplInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmplInfoApplication.class, args);
    }

}
