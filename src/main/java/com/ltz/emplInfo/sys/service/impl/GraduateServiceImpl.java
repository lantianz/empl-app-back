package com.ltz.emplInfo.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltz.emplInfo.sys.entity.Graduate;
import com.ltz.emplInfo.sys.mapper.GraduateMapper;
import com.ltz.emplInfo.sys.service.IGraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
