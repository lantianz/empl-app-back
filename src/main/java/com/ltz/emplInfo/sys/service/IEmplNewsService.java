package com.ltz.emplInfo.sys.service;

import com.ltz.emplInfo.sys.entity.EmplNews;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ltz.emplInfo.sys.entity.Graduate;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-18
 */
public interface IEmplNewsService extends IService<EmplNews> {

    List<EmplNews> getEmplNewsBySearch(String keyword);

    boolean add(EmplNews emplNews);

    boolean deleteByNewsId(String newsId);

    boolean editByNewsId(EmplNews emplNews);
}
