package com.ltz.emplInfo.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ltz.emplInfo.sys.entity.Admin;

import java.util.List;
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

    String login(Admin admin);

    Map<String, Object> getAdminInfo(String token);

    void logout(String token);

    List<Admin> getDeptAdmin(Integer adminId);

    List<Admin> getDeptAdminBySearch(String keyword);

    boolean add(Admin deptAdmin);

    boolean deleteById(String id);

    boolean editById(Admin deptAdmin);

    boolean deleteAllByIds(List<String> ids);

    boolean editPwdById(Admin admin);

    Admin getAdminByJobId(String jobId);
}
