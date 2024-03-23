package com.ltz.emplInfo.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltz.emplInfo.sys.entity.EmplInfoCheck;
import com.ltz.emplInfo.sys.mapper.EmplInfoCheckMapper;
import com.ltz.emplInfo.sys.service.IEmplInfoCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-22
 */
@Service
public class EmplInfoCheckServiceImpl extends ServiceImpl<EmplInfoCheckMapper, EmplInfoCheck> implements IEmplInfoCheckService {

    @Autowired
    private EmplInfoCheckMapper emplInfoCheckMapper;

    @Override
    public boolean add(EmplInfoCheck emplInfoCheck) {
        return emplInfoCheckMapper.add(emplInfoCheck);
    }

    @Override
    public boolean delete(String id) {
        return emplInfoCheckMapper.delete(id);
    }

    @Override
    public boolean edit(EmplInfoCheck emplInfoCheck) {
        return emplInfoCheckMapper.edit(emplInfoCheck);
    }

    @Override
    public EmplInfoCheck getByStudentId(String studentId) {
        return emplInfoCheckMapper.getByStudentId(studentId);
    }
}
