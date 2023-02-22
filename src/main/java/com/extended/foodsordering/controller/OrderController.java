package com.extended.foodsordering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.extended.foodsordering.bean.FinalResponse;
import com.extended.foodsordering.bean.Order;
import com.extended.foodsordering.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/save")
	public FinalResponse getOrderInfo(@RequestBody Order order){
		return orderService.placeOrder(order);
	}
	
	@DeleteMapping("/deletebyid")
	public FinalResponse getDeleteOrder(@RequestParam ("orderId") int id) {
		return orderService.deleteOrder(id);
	}
	
	@PutMapping("update")
	public FinalResponse getUpdateOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}
	
	@GetMapping("/getall")
	public FinalResponse getAllOrderdetails(){
		return orderService.getAllOrder();
	}
}
