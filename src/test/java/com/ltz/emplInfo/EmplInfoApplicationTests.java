package com.ltz.emplInfo;

import com.ltz.emplInfo.sys.entity.Admin;
import com.ltz.emplInfo.sys.mapper.AdminMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class EmplInfoApplicationTests {

    @Resource
    private AdminMapper adminMapper;

    @Test
    void contextLoads() {
        List<Admin> admins = adminMapper.selectList(null);
        admins.forEach(System.out::println);
    }

}
