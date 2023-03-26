package com.lecheng.takeout.service;

import com.lecheng.takeout.common.R;
import com.lecheng.takeout.entity.Category;

public interface CategoryService {
    R addCategory(Category category);

    R page(Integer page, Integer pageSize);

    R removeCategoryById(Long id);

    R modifyCategoryById(Category category);

    R findListByType(Integer type);
}
