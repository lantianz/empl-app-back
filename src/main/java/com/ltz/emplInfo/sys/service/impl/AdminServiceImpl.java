package com.ltz.emplInfo.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.ltz.emplInfo.common.vo.Result;
import com.ltz.emplInfo.sys.entity.Admin;
import com.ltz.emplInfo.sys.mapper.AdminMapper;
import com.ltz.emplInfo.sys.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tianzhi
 * @since 2024-02-04
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, Object> login(Admin admin) {
        // 根据用户名和密码查询
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getUsername,admin.getUsername());
        wrapper.eq(Admin::getPassword,admin.getPassword());
        Admin loginAdmin = this.baseMapper.selectOne(wrapper);
        // 结果不为空，生成token，并将信息存入redis
        if(loginAdmin != null){
            // 暂时用UUID，终极方案是jwt
            String key = "admin:" + UUID.randomUUID();

            // 存入redis
            loginAdmin.setPassword(null);
            redisTemplate.opsForValue().set(key, loginAdmin,30, TimeUnit.MINUTES);

            // 返回数据
            Map<String, Object> data = new HashMap<>();
            data.put("token", key);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> getAdminInfo(String token) {
        // 根据token获取用户信息
        Object obj = redisTemplate.opsForValue().get(token);
        if(obj != null){
            Admin loginAdmin = JSON.parseObject(JSON.toJSONString(obj), Admin.class);
            Map<String, Object> data = new HashMap<>();
            data.put("name", loginAdmin.getUsername());

            // 获取角色等级
            List<String> roleList = this.baseMapper.getRoleByUserId(loginAdmin.getEmployeeId());
            data.put("role", roleList);

            return data;
        }
        return null;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }
}
