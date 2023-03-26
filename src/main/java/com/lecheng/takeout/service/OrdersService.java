package com.lecheng.takeout.service;

import com.lecheng.takeout.common.R;
import com.lecheng.takeout.entity.Orders;

import java.util.Date;

public interface OrdersService {
    R submit(Orders orders);

    R page(Integer page, Integer pageSize, String number, Date beginTime, Date endTime);

    R userPage(Integer page, Integer pageSize);

    R modifyStatus(Orders orders);

    void updateStatus(String out_trade_no, String transaction_id);

    R findStatusById(String orderId);
}
