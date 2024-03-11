package com.ltz.emplInfo.sys.mapper;

import com.ltz.emplInfo.sys.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ltz.emplInfo.sys.entity.Role;
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
public interface AdminMapper extends BaseMapper<Admin> {
    Role getRoleByUserId(Integer adminId);

    List<Admin> getDeptAdmin(Integer adminId);

    List<Admin> getDeptAdminBySearch(String keyword);

    boolean add(Admin deptAdmin);

    boolean deleteById(String id);

    boolean editById(Admin deptAdmin);

    boolean deleteAllByIds(@Param("ids") List<String> ids);
}
