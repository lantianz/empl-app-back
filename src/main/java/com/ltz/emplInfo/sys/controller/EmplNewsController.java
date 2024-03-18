package com.ltz.emplInfo.sys.controller;

import com.ltz.emplInfo.common.vo.Result;
import com.ltz.emplInfo.sys.entity.EmplNews;
import com.ltz.emplInfo.sys.entity.Graduate;
import com.ltz.emplInfo.sys.service.IEmplNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-18
 */
@RestController
@RequestMapping("/api/emplNews")
public class EmplNewsController {
    @Autowired
    private IEmplNewsService emplNewsService;

    @GetMapping("/getEmplNews")
    public Result<List<EmplNews>> getAllEmplNews() {
        List<EmplNews> list = emplNewsService.list();
        Result<List<EmplNews>> result = new Result<>();
        result.setData(list);
        result.setTotal(list.size());
        result.setMessage("全部就业资讯");
        return result;
    }

    @GetMapping("/getEmplNewsBySearch")
    public Result<List<EmplNews>> getEmplNewsBySearch(@RequestParam("keyword") String keyword) {
        List<EmplNews> list = emplNewsService.getEmplNewsBySearch(keyword);
        Result<List<EmplNews>> result = new Result<>();
        result.setData(list);
        result.setTotal(list.size());
        result.setMessage("全部就业资讯");
        return result;
    }

    @PostMapping("/addEmplNews")
    public Result<String> addEmplNews(@RequestBody EmplNews emplNews) {
        boolean added = emplNewsService.add(emplNews);
        if (added) {
            return Result.success("添加资讯成功");
        } else {
            return Result.fail("添加资讯失败");
        }
    }

    @DeleteMapping("/deleteEmplNews/{newsId}")
    public Result<String> deleteEmplNews(@PathVariable("newsId") String newsId) {
        boolean deleted = emplNewsService.deleteByNewsId(newsId);
        if (deleted) {
            return Result.success("删除成功");
        } else {
            return Result.fail("删除失败，可能不存在");
        }
    }

    @PutMapping("/editEmplNews")
    public Result<String> editEmplNews(@RequestBody EmplNews emplNews) {
        boolean updated = emplNewsService.editByNewsId(emplNews);
        if (updated) {
            return Result.success("更新资讯成功");
        } else {
            return Result.fail("更新资讯失败，可能该资讯不存在");
        }
    }

}
