package com.ltz.emplInfo.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ltz.emplInfo.sys.entity.Permission;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-07
 */
@Service
public interface PermissionMapper extends BaseMapper<Permission> {


    List<Permission> getMenu(Integer roleId);
}
