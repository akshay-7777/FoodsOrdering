package com.extended.foodsordering.controller;

import java.util.List;

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
import com.extended.foodsordering.bean.OrderDetails;
import com.extended.foodsordering.service.OrderDetailsService;


@RestController
@RequestMapping("/orderdetails")
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@GetMapping("/getall")
	public FinalResponse allOrderdetails(){
		return orderDetailsService.viewAllOrder();
	}
	
	@PostMapping("/save")
	public FinalResponse placedOrderDetailsInfo(@RequestBody OrderDetails orderDetails){
		return orderDetailsService.orderPlaced(orderDetails);
	}
	
	@DeleteMapping("/deletebyid")
	public FinalResponse getDeleteId(@RequestParam ("orderDetailsId") int id) {
		return orderDetailsService.deleteOrderById(id);
	}
	
	@PutMapping("update")
	public FinalResponse getUpdateData(@RequestBody OrderDetails orderDetail) {
		return orderDetailsService.updateOrder(orderDetail);
	}
	
	@GetMapping("/getbyid")
	public FinalResponse getOrderDetails(@RequestParam ("orderDetailsId") int id) {
		return orderDetailsService.orderViewById(id);
	}
	
	@PostMapping("/savemultiple")
	public FinalResponse getInsertMultipleCustomerInfo(@RequestBody List<OrderDetails> orderDetail){
		return orderDetailsService.multipleOrderPlaced(orderDetail);
	}
}
