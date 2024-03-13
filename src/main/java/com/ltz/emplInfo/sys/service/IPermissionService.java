package com.ltz.emplInfo.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ltz.emplInfo.sys.entity.Permission;

import java.util.List;

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
