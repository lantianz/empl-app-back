package com.ltz.emplInfo.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltz.emplInfo.sys.entity.Admin;
import com.ltz.emplInfo.sys.entity.Role;
import com.ltz.emplInfo.sys.mapper.AdminMapper;
import com.ltz.emplInfo.sys.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tianzhi
 * @since 2024-02-04
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String login(Admin admin) {
        // 根据用户名和密码查询
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getUsername, admin.getUsername());
        wrapper.eq(Admin::getPassword, admin.getPassword());
        Admin loginAdmin = this.baseMapper.selectOne(wrapper);
        // 结果不为空，生成token，并将信息存入redis
        if (loginAdmin != null) {
            // UUID
            String key = "admin:" + UUID.randomUUID();

            // 存入redis，设定token过期时间
            loginAdmin.setPassword(null);
            redisTemplate.opsForValue().set(key, loginAdmin, 12, TimeUnit.HOURS);

            // 返回数据
            return key;
        }
        return null;
    }

    @Override
    public Map<String, Object> getAdminInfo(String token) {
        // 根据token获取用户信息
        Object obj = redisTemplate.opsForValue().get(token);
        if (obj != null) {
            Admin loginAdmin = JSON.parseObject(JSON.toJSONString(obj), Admin.class);
            Map<String, Object> data = new HashMap<>();
            data.put("jobId", loginAdmin.getJobId());
            data.put("name", loginAdmin.getName());
            data.put("phone", loginAdmin.getPhone());
            data.put("email", loginAdmin.getEmail());
            data.put("username", loginAdmin.getUsername());
            // 获取角色等级
            Role roles = this.baseMapper.getRoleByUserId(loginAdmin.getAdminId());
            data.put("role", roles);

            return data;
        }
        return null;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }

    @Override
    public List<Admin> getDeptAdmin(Integer adminId) {
        return adminMapper.getDeptAdmin(adminId);
    }

    @Override
    public List<Admin> getDeptAdminBySearch(String keyword) {
        return adminMapper.getDeptAdminBySearch(keyword);
    }

    @Override
    public boolean add(Admin deptAdmin) {
        return adminMapper.add(deptAdmin);
    }

    @Override
    public boolean deleteById(String id) {
        return adminMapper.deleteById(id);
    }

    @Override
    public boolean editById(Admin deptAdmin) {
        return adminMapper.editById(deptAdmin);
    }

    @Override
    public boolean deleteAllByIds(List<String> ids) {
        return adminMapper.deleteAllByIds(ids);
    }

    @Override
    public boolean editPwdById(Admin admin) {
        return adminMapper.editPwdById(admin);
    }

    @Override
    public Admin getAdminByJobId(String jobId) {
        return adminMapper.getAdminByJobId(jobId);
    }
}
