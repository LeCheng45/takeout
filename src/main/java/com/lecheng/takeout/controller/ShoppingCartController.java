package com.lecheng.takeout.controller;

import com.lecheng.takeout.common.R;
import com.lecheng.takeout.entity.ShoppingCart;
import com.lecheng.takeout.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 购物车
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;
    
    /**
     * 购物车列表
     * @return
     */
    @GetMapping("/list")
    public R findAll(){
        return shoppingCartService.findAll();
    }
    
    /**
     * 添加购物车
     * @param shoppingCart
     * @return
     */
    @PostMapping("/add")
    public R add(@RequestBody ShoppingCart shoppingCart){
        return shoppingCartService.add(shoppingCart);
    }
    
    /**
     * 清空购物车
     * @return
     */
    @DeleteMapping("/clean")
    public R clean(){
        return shoppingCartService.clean();
    }
    
    /**
     * 修改
     * @param shoppingCart
     * @return
     */
    @PostMapping("/sub")
    public R sub(@RequestBody ShoppingCart shoppingCart){
        return shoppingCartService.sub(shoppingCart);
    }

}
