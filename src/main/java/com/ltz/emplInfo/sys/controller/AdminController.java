package com.ltz.emplInfo.sys.controller;

import com.ltz.emplInfo.common.vo.Result;
import com.ltz.emplInfo.sys.entity.Admin;
import com.ltz.emplInfo.sys.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @GetMapping("/check")   //验证token是否过期
    public Result<Map<String,Object>> check(@RequestHeader("A-Token") String token){
        Map<String,Object> data = adminService.getAdminInfo(token);
        if (data != null) {
            return Result.success();
        } else {
            return Result.fail("登录信息过期，请重新登陆");
        }
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("A-Token") String token){
        adminService.logout(token);
        return Result.success();
    }

    @GetMapping("/allDeptAdmin")
    public Result<List<Admin>> getAllDeptAdmin(){
        List<Admin> list = adminService.getDeptAdmin(3);
        Result<List<Admin>> result = new Result<>();
        result.setData(list);
        result.setTotal(list.size());
        return result;
    }
    @GetMapping("/getDeptAdminBySearch")
    public Result<List<Admin>> getDeptAdminBySearch(@RequestParam("keyword") String keyword) {
        List<Admin> list = adminService.getDeptAdminBySearch(keyword);
        Result<List<Admin>> result = new Result<>();
        result.setData(list);
        result.setTotal(list.size());
        result.setMessage("找到了");
        return result;
    }

    @PostMapping("/addDeptAdmin")
    public Result<String> addDeptAdmin(@RequestBody Admin deptAdmin) {
        boolean added = adminService.add(deptAdmin);
        if (added) {
            return Result.success("添加负责人成功");
        } else {
            return Result.fail("添加负责人失败");
        }
    }

    @DeleteMapping("/deleteDeptAdmin/{id}")
    public Result<String> deleteDeptAdmin(@PathVariable("id") String id) {
        boolean deleted = adminService.deleteById(id);
        if (deleted) {
            return Result.success("删除负责人成功");
        } else {
            return Result.fail("删除负责人失败，可能该负责人不存在");
        }
    }

    @DeleteMapping("/deleteAllDeptAdmin/{ids}")
    public Result<String> deleteAllDeptAdmin(@PathVariable("ids") List<String> ids) {
        boolean deleted = adminService.deleteAllByIds(ids);
        if (deleted) {
            return Result.success("删除成功");
        } else {
            return Result.fail("删除失败，可能负责人不存在");
        }
    }

    @PutMapping("/editDeptAdmin")
    public Result<String> editDeptAdmin(@RequestBody Admin deptAdmin) {
        boolean updated = adminService.editById(deptAdmin);
        if (updated) {
            return Result.success("更新负责人信息成功");
        } else {
            return Result.fail("更新负责人信息失败，可能该负责人不存在");
        }
    }

    @PutMapping("/changePwd")
    public Result<String> editAdminPwd(@RequestBody Admin admin) {
        if (!Objects.equals(adminService.getAdminByJobId(admin.getJobId()).getPassword(), admin.getOldPwd())) {
            return Result.fail("旧密码错误");
        }
        if (Objects.equals(adminService.getAdminByJobId(admin.getJobId()).getPassword(), admin.getPassword())) {
            return Result.fail("新密码不能与旧密码相同");
        }
        boolean updated = adminService.editPwdById(admin);
        if (updated) {
            return Result.success("更改密码成功");
        } else {
            return Result.fail("更改密码失败");
        }
    }

}
