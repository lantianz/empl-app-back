package com.ltz.emplInfo.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ltz.emplInfo.sys.entity.Graduate;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tianzhi
 * @since 2024-02-04
 */
public interface IGraduateService extends IService<Graduate> {

    List<Graduate> getGraduatesByPage(int pageNum, int pageSize);

    boolean deleteById(String deleteId);

    boolean editById(Graduate graduate);

    boolean add(Graduate graduate);

    List<Graduate> getAllGraduate();

    List<Graduate> getGraduateBySearch(String keyword);

    boolean editByList(List<String> ids, String password);

    List<Graduate> getDeptGraduateBySearch(String dept);
}
