package com.ltz.emplInfo.sys.service;

import com.ltz.emplInfo.sys.entity.Admin;
import com.ltz.emplInfo.sys.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-07
 */
public interface IPermissionService extends IService<Permission> {

    List<Permission> getMenu(Integer roleId);
}
