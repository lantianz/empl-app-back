package com.ltz.emplInfo.sys.controller;

import com.ltz.emplInfo.common.vo.Result;
import com.ltz.emplInfo.sys.entity.Admin;
import com.ltz.emplInfo.sys.entity.EmplInfo;
import com.ltz.emplInfo.sys.entity.Graduate;
import com.ltz.emplInfo.sys.service.IAdminService;
import com.ltz.emplInfo.sys.service.IGraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tianzhi
 * @since 2024-02-04
 */
@RestController
@RequestMapping("/api/graduate")
public class GraduateController {
    @Autowired
    private IGraduateService  graduateService;

    @GetMapping("/getAllUserByPage")
    public Result<List<Graduate>> getAllGraduateByPage(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        List<Graduate> allGraduates = graduateService.getAllGraduate(); // 获取全部毕业生数据(除了密码)
        // List<Graduate> allGraduates = graduateService.list();   // 获取全部毕业生数据
        // 计算当前页的起始索引和结束索引
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, allGraduates.size());
        // 获取当前页的毕业生列表
        List<Graduate> currentPageGraduates = allGraduates.subList(startIndex, endIndex);
        // 构建返回对象
        Result<List<Graduate>> result = new Result<>();

        // result.setData(allGraduates);   // 全部
        result.setData1(currentPageGraduates);  // 单页
        result.setTotal(allGraduates.size());
        result.setMessage("data1为第 " + pageNum + " 页的结果，data为全部结果");

        return result;
    }

    @GetMapping("/getUserBySearch")
    public Result<List<Graduate>> getGraduateBySearch(@RequestParam("keyword") String keyword) {
        List<Graduate> list = graduateService.getGraduateBySearch(keyword);
        Result<List<Graduate>> result = new Result<>();
        result.setData(list);
        result.setTotal(list.size());
        result.setMessage("找到了");
        return result;
    }

    @PostMapping("/addUser")
    public Result<String> addGraduate(@RequestBody Graduate graduate) {
        boolean added = graduateService.add(graduate);
        if (added) {
            return Result.success("添加毕业生成功");
        } else {
            return Result.fail("添加毕业生失败");
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public Result<String> deleteGraduate(@PathVariable("id") String id) {
        boolean deleted = graduateService.deleteById(id);
        if (deleted) {
            return Result.success("删除毕业生成功");
        } else {
            return Result.fail("删除毕业生失败，可能该毕业生不存在");
        }
    }

    @PutMapping("/editUser")
    public Result<String> editGraduate(@RequestBody Graduate graduate) {
        boolean updated = graduateService.editById(graduate);
        if (updated) {
            return Result.success("更新毕业生信息成功");
        } else {
            return Result.fail("更新毕业生信息失败，可能该毕业生不存在");
        }
    }
}
