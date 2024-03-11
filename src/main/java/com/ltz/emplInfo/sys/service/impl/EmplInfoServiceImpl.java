package com.ltz.emplInfo.sys.service.impl;

import com.ltz.emplInfo.sys.entity.EmplInfo;
import com.ltz.emplInfo.sys.entity.Graduate;
import com.ltz.emplInfo.sys.mapper.EmplInfoMapper;
import com.ltz.emplInfo.sys.service.IEmplInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-09
 */
@Service
public class EmplInfoServiceImpl extends ServiceImpl<EmplInfoMapper, EmplInfo> implements IEmplInfoService {
    @Autowired
    private EmplInfoMapper emplInfoMapper;

    @Override
    public List<EmplInfo> getEmplInfoBySearch(String keyword) {
        return emplInfoMapper.getEmplInfoBySearch(keyword);
    }

    @Override
    public boolean add(EmplInfo emplInfo) {
        return emplInfoMapper.add(emplInfo);
    }

    @Override
    public boolean deleteById(String id) {
        return emplInfoMapper.deleteById(id);
    }

    @Override
    public boolean editById(EmplInfo emplInfo) {
        return emplInfoMapper.editById(emplInfo);
    }

    @Override
    public boolean deleteAllByIds(List<String> ids) {
        return emplInfoMapper.deleteAllByIds(ids);
    }
}
