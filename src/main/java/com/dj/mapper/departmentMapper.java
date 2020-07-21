package com.dj.mapper;

import com.dj.domain.department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface departmentMapper {

    List<department> selectAll();
}