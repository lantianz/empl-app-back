package com.ltz.emplInfo.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltz.emplInfo.sys.entity.Admin;
import com.ltz.emplInfo.sys.entity.Graduate;
import com.ltz.emplInfo.sys.mapper.GraduateMapper;
import com.ltz.emplInfo.sys.service.IGraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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
public class GraduateServiceImpl extends ServiceImpl<GraduateMapper, Graduate> implements IGraduateService {

    @Autowired
    private GraduateMapper graduateMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Graduate> getGraduatesByPage(int pageNum, int pageSize) {
        int startIndex = (pageNum - 1) * pageSize;
        return graduateMapper.getGraduatesByPage(startIndex, pageSize);
    }

    @Override
    public boolean deleteById(String deleteId) {
        return graduateMapper.deleteById(deleteId);
    }

    @Override
    public boolean editById(Graduate graduate) {
        return graduateMapper.editById(graduate);
    }

    @Override
    public boolean add(Graduate graduate) {
        return graduateMapper.add(graduate);
    }

    @Override
    public List<Graduate> getAllGraduate() {
        return graduateMapper.getAllGraduate();
    }

    @Override
    public List<Graduate> getGraduateBySearch(String keyword) {
        return graduateMapper.getGraduateBySearch(keyword);
    }

    @Override
    public boolean editByList(List<String> ids, String password) {
        return graduateMapper.editByList(ids, password);
    }

    @Override
    public List<Graduate> getDeptGraduateBySearch(String dept) {
        return graduateMapper.getDeptGraduateBySearch(dept);
    }

    @Override
    public String login(Graduate graduate) {
        // 根据用户名和密码查询
        LambdaQueryWrapper<Graduate> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Graduate::getUsername,graduate.getUsername());
        wrapper.eq(Graduate::getPassword,graduate.getPassword());
        Graduate loginGraduate = this.baseMapper.selectOne(wrapper);
        // 结果不为空，生成token，并将信息存入redis
        if(loginGraduate != null){
            // UUID
            String key = "graduate:" + UUID.randomUUID();

            // 存入redis，设定token过期时间
            loginGraduate.setPassword(null);
            redisTemplate.opsForValue().set(key, loginGraduate, 12, TimeUnit.HOURS);

            // 返回数据
            return key;
        }
        return null;
    }
}
