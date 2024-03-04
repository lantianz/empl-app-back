package com.ltz.emplInfo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("admin")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer employeeId;

    private String name;

    private String phone;

    private String username;

    private String password;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminCopy1{" +
                "employeeId = " + employeeId +
                ", name = " + name +
                ", phone = " + phone +
                ", username = " + username +
                ", password = " + password +
                "}";
    }
}
