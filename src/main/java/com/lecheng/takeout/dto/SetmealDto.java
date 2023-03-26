package com.lecheng.takeout.dto;

import com.lecheng.takeout.entity.Setmeal;
import com.lecheng.takeout.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
