package com.ltz.emplInfo.sys.controller;

import com.ltz.emplInfo.common.vo.Result;
import com.ltz.emplInfo.sys.entity.Admin;
import com.ltz.emplInfo.sys.entity.Graduate;
import com.ltz.emplInfo.sys.entity.StandInfo;
import com.ltz.emplInfo.sys.service.IStandInfoService;
import com.ltz.emplInfo.sys.service.impl.StandInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-04
 */
@RestController
@RequestMapping("/api/standInfo")
public class StandInfoController {
    @Autowired
    private IStandInfoService standInfoService;


    @GetMapping("/getStandInfo")
    public Result<List<StandInfo>> getStandInfo() {
        List<StandInfo> list = standInfoService.list();
        return Result.success(list,"success!!!");
    }
}
