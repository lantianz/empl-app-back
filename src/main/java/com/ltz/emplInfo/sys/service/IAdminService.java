package com.ltz.emplInfo.sys.service;

import com.ltz.emplInfo.sys.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tianzhi
 * @since 2024-02-04
 */
public interface IAdminService extends IService<Admin> {

    Map<String, Object> login(Admin admin);

    Map<String, Object> getAdminInfo(String token);

    void logout(String token);
}
