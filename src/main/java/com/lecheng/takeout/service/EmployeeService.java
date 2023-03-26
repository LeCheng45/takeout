package com.lecheng.takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lecheng.takeout.common.R;
import com.lecheng.takeout.entity.Employee;


public interface EmployeeService extends IService<Employee> {
    R login(Employee employee);

    R updateStatus(Employee employee);

    R findById(Long id);
}
