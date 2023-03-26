package com.lecheng.takeout.service;

import com.lecheng.takeout.common.R;
import com.lecheng.takeout.entity.ShoppingCart;

public interface ShoppingCartService {
    R findAll();

    R add(ShoppingCart shoppingCart);

    R clean();

    R sub(ShoppingCart shoppingCart);
}
