package com.ltz.emplInfo.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltz.emplInfo.sys.entity.Permission;
import com.ltz.emplInfo.sys.mapper.PermissionMapper;
import com.ltz.emplInfo.sys.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-07
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getMenu(Integer roleId) {
        return permissionMapper.getMenu(roleId);
    }
}
