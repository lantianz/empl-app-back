package com.ltz.emplInfo.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ltz.emplInfo.sys.entity.EmplInfoCheck;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-22
 */
public interface IEmplInfoCheckService extends IService<EmplInfoCheck> {

    boolean add(EmplInfoCheck emplInfoCheck);

    boolean delete(String id);

    boolean edit(EmplInfoCheck emplInfoCheck);

    EmplInfoCheck getByStudentId(String studentId);
}
