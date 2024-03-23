package com.ltz.emplInfo.sys.controller;

import com.ltz.emplInfo.common.vo.Result;
import com.ltz.emplInfo.sys.entity.StandInfo;
import com.ltz.emplInfo.sys.service.IStandInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * <p>
 * 前端控制器
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
    public Result<Map<String, Object>> getStandInfo() {
        List<StandInfo> list = standInfoService.list();

        Map<String, Object> result = new HashMap<>();
        Map<String, List<String>> filteredFields = new HashMap<>();

        // 遍历数据列表，进行过滤
        for (StandInfo standInfo : list) {
            // 过滤非空的字段
            filterField(filteredFields, "id", String.valueOf(standInfo.getId()));
            filterField(filteredFields, "department", standInfo.getDepartment());
            filterField(filteredFields, "major", standInfo.getMajor());
            filterField(filteredFields, "company_type", standInfo.getCompanyType());
            filterField(filteredFields, "province", standInfo.getProvince());
            filterField(filteredFields, "city", standInfo.getCity());
            filterField(filteredFields, "grade", standInfo.getGrade());
        }
        result.put("standInfo", filteredFields);

        return Result.success(result, "success!!!");
    }

    // 过滤非空字段并存储到List中
    private void filterField(Map<String, List<String>> filteredFields, String fieldName, String value) {
        if (!Objects.isNull(value) && !value.equals("")) {
            filteredFields.computeIfAbsent(fieldName, k -> new ArrayList<>()).add(value);
        }
    }


}
