package com.extended.foodsordering.service;

import java.util.List;

import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.bean.OrderDetails;

public interface OrderDetailsService {

	public FinalResponse orderPlaced(OrderDetails orderDetails);
    public FinalResponse multipleOrderPlaced(List<OrderDetails> orderDetails);
    public FinalResponse orderViewById(int id) ;
    public FinalResponse viewAllOrder() ;
    public FinalResponse deleteOrderById(int id);
    public FinalResponse updateOrder(OrderDetails orderDetails);
}
