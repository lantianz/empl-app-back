package com.ltz.emplInfo.sys.mapper;

import com.ltz.emplInfo.sys.entity.Graduate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tianzhi
 * @since 2024-02-04
 */
@Service
public interface GraduateMapper extends BaseMapper<Graduate> {

    List<Graduate> getGraduatesByPage(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize); //(多个参数需要使用Param注解)Param包导错了搞了半天。。。

    boolean deleteById(String deleteId);

    boolean editById(Graduate graduate);

    boolean add(Graduate graduate);

    List<Graduate> getAllGraduate();

    List<Graduate> getGraduateBySearch(String keyword);
}
