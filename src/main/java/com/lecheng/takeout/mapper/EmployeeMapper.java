package com.lecheng.takeout.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lecheng.takeout.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
