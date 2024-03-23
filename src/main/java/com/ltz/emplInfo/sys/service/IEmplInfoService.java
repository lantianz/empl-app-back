package com.ltz.emplInfo.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ltz.emplInfo.sys.entity.EmplInfo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-09
 */
public interface IEmplInfoService extends IService<EmplInfo> {

    List<EmplInfo> getEmplInfoBySearch(String keyword);

    boolean add(EmplInfo emplInfo);

    boolean deleteById(String id);

    boolean editById(EmplInfo emplInfo);

    boolean deleteAllByIds(List<String> ids);

    int countOfGraduate(String department, String major, String grade);

    int countOfEmployed(String department, String major, String company_type, String company_city, String grade);

    int countOfOnTime(String dept, String grade);
}
