package com.ltz.emplInfo.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ltz.emplInfo.sys.entity.EmplInfoCheck;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-22
 */
@Service
public interface EmplInfoCheckMapper extends BaseMapper<EmplInfoCheck> {

    boolean add(EmplInfoCheck emplInfoCheck);

    boolean delete(String id);

    boolean edit(EmplInfoCheck emplInfoCheck);

    EmplInfoCheck getByStudentId(String studentId);
}
