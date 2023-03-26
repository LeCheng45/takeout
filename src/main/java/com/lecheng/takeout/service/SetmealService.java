package com.lecheng.takeout.service;

import com.lecheng.takeout.common.R;
import com.lecheng.takeout.dto.SetmealDto;
import com.lecheng.takeout.entity.Setmeal;

public interface SetmealService {
    R findSetmeal(Integer page, Integer pageSize, String name);

    R saveSetmealWithDish(SetmealDto setmealDto);

    R findSetmealById(Long id);

    R modifyByIdWithDish(SetmealDto setmealDto);

    R removeByIdsWithDish(Long[] ids);

    R findSetmealByCategroyId(Setmeal setmeal);

    R modifyByStatus(Integer status, Long[] ids);
}
