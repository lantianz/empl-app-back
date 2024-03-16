package com.ltz.emplInfo.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ltz.emplInfo.sys.entity.EmplInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-09
 */
@Service
public interface EmplInfoMapper extends BaseMapper<EmplInfo> {

    List<EmplInfo> getEmplInfoBySearch(String keyword);

    boolean add(EmplInfo emplInfo);

    boolean deleteById(String id);

    boolean editById(EmplInfo emplInfo);

    boolean deleteAllByIds(@Param("ids") List<String> ids);

    int countOfGraduate(@Param("department") String department, @Param("major") String major, @Param("grade") String grade);

    int countOfEmployed(@Param("department") String department, @Param("major") String major,
                        @Param("company_type") String company_type, @Param("company_city") String company_city,
                        @Param("grade") String grade);

    int countOfOnTime(@Param("department") String department, @Param("grade") String grade);
}
