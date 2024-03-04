package com.ltz.emplInfo.sys.mapper;

import com.ltz.emplInfo.sys.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tianzhi
 * @since 2024-02-04
 */
public interface AdminMapper extends BaseMapper<Admin> {
    List<String> getRoleByUserId(Integer userId);
}
