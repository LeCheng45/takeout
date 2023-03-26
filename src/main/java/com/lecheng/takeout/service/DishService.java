package com.lecheng.takeout.service;

import com.lecheng.takeout.common.R;
import com.lecheng.takeout.dto.DishDto;
import com.lecheng.takeout.entity.Dish;

public interface DishService {
    R saveWithDishFlavor(DishDto dishDto);

    R findDish(Integer page, Integer pageSize, String name);

    R getByIdWithFlavor(Long id);

    R modifyByIdWithFlavor(DishDto dishDto);

    R removeByIdsWithFlavor(Long[] ids);


    R findDishByCategroyId(Dish dish);

    R modifyByStatus(Integer status, Long[] ids);
}
