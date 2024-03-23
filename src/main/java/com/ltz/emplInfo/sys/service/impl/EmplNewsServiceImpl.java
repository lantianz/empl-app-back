package com.ltz.emplInfo.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltz.emplInfo.sys.entity.EmplNews;
import com.ltz.emplInfo.sys.mapper.EmplNewsMapper;
import com.ltz.emplInfo.sys.service.IEmplNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-18
 */
@Service
public class EmplNewsServiceImpl extends ServiceImpl<EmplNewsMapper, EmplNews> implements IEmplNewsService {
    @Autowired
    private EmplNewsMapper emplNewsMapper;

    @Override
    public List<EmplNews> getEmplNewsBySearch(String keyword) {
        return emplNewsMapper.getEmplNewsBySearch(keyword);
    }

    @Override
    public boolean add(EmplNews emplNews) {
        return emplNewsMapper.add(emplNews);
    }

    @Override
    public boolean deleteByNewsId(String newsId) {
        return emplNewsMapper.deleteByNewsId(newsId);
    }

    @Override
    public boolean editByNewsId(EmplNews emplNews) {
        return emplNewsMapper.editByNewsId(emplNews);
    }
}
