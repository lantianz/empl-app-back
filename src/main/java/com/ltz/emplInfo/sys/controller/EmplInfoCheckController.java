package com.ltz.emplInfo.sys.controller;

import com.ltz.emplInfo.common.vo.Result;
import com.ltz.emplInfo.sys.entity.EmplInfoCheck;
import com.ltz.emplInfo.sys.service.IEmplInfoCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ltz.emplInfo.util.Convert.convertEmplInfoCheck;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-22
 */
@RestController
@RequestMapping("/api/emplInfoCheck")
public class EmplInfoCheckController {
    @Autowired
    private IEmplInfoCheckService emplInfoCheckService;

    @GetMapping("/all")
    public Result<List<EmplInfoCheck>> getAllCheck() {
        List<EmplInfoCheck> list = emplInfoCheckService.list();
        for (EmplInfoCheck info : list) {
            convertEmplInfoCheck(info);
        }
        Result<List<EmplInfoCheck>> result = new Result<>();
        result.setCode(20000);
        result.setData(list);
        result.setTotal(list.size());
        result.setMessage("全部审核就业信息");
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Result<String> deleteCheck(@PathVariable("id") String id) {
        boolean deleted = emplInfoCheckService.delete(id);
        if (deleted) {
            return Result.success("删除成功");
        } else {
            return Result.fail("删除失败，可能不存在");
        }
    }

    @PutMapping("/edit")
    public Result<String> editCheck(@RequestBody EmplInfoCheck emplInfoCheck) {
        convertEmplInfoCheck(emplInfoCheck);
        boolean updated = emplInfoCheckService.edit(emplInfoCheck);
        if (updated) {
            return Result.success("更新成功");
        } else {
            return Result.fail("更新失败，可能不存在");
        }
    }

}
