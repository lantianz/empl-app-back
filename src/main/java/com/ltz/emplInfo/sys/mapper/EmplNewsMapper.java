package com.ltz.emplInfo.sys.mapper;

import com.ltz.emplInfo.sys.entity.EmplNews;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-18
 */
@Service
public interface EmplNewsMapper extends BaseMapper<EmplNews> {

    List<EmplNews> getEmplNewsBySearch(String keyword);

    boolean add(EmplNews emplNews);

    boolean deleteByNewsId(String newsId);

    boolean editByNewsId(EmplNews emplNews);
}
