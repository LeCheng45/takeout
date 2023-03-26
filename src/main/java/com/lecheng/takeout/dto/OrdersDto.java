package com.lecheng.takeout.dto;

import com.lecheng.takeout.entity.OrderDetail;
import com.lecheng.takeout.entity.Orders;
import lombok.Data;
import java.util.List;

@Data
public class OrdersDto extends Orders {

    private String userName;

    private String phone;

    private String address;

    private String consignee;

    private List<OrderDetail> orderDetails;
	
}
