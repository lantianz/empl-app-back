package com.ltz.emplInfo.sys.service;

import com.ltz.emplInfo.sys.entity.EmplInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ltz.emplInfo.sys.entity.Graduate;

import java.util.List;

/**
 * <p>
 *  服务类
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
}
