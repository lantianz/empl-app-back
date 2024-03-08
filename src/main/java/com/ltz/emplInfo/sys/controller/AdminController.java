package com.ltz.emplInfo.sys.controller;

import com.ltz.emplInfo.common.vo.Result;
import com.ltz.emplInfo.sys.entity.Admin;
import com.ltz.emplInfo.sys.entity.Permission;
import com.ltz.emplInfo.sys.service.IAdminService;
import com.ltz.emplInfo.sys.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tianzhi
 * @since 2024-02-04
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;
    private PermissionController permissionController;

    @GetMapping("/all")
    public Result<List<Admin>> getAllAdmin(){
        List<Admin> list = adminService.list();
        return Result.success(list,"success!!!");
    }

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody Admin admin){
        Map<String,Object> data = new HashMap<>();
        String token = adminService.login(admin);
        data.put("token",token);
        if (token != null) {
            data.put("info", adminService.getAdminInfo(token));
            return Result.success(data);
        } else {
            return Result.fail(20002,"用户名or密码错误");
        }
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("A-Token") String token){
        adminService.logout(token);
        return Result.success();
    }

}
