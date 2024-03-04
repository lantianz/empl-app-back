package com.ltz.emplInfo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tianzhi
 * @since 2024-02-04
 */
@TableName("admin_role")
public class AdminRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer employeeId;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "AdminRole{" +
            "id = " + id +
            ", employeeId = " + employeeId +
            ", roleId = " + roleId +
        "}";
    }
}
