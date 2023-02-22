package com.extended.foodsordering.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extended.foodsordering.bean.NotificationRequest;
import com.extended.foodsordering.utility.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	    @Autowired
	    private NotificationService notificationService;
	    
	    @PostMapping("/topic")
	    public String sendPnsToTopic(@RequestBody NotificationRequest notificationRequestDto) {
	        return notificationService.sendPnsToTopic(notificationRequestDto);
	    }

	    /*
	    @PostMapping("/subscribe")
	    public void subscribeToTopic(@RequestBody SubscriptionRequest subscriptionRequestDto) {
	        notificationService.subscribeToTopic(subscriptionRequestDto);
	    }

	    @PostMapping("/unsubscribe")
	    public void unsubscribeFromTopic(SubscriptionRequest subscriptionRequestDto) {
	        notificationService.unsubscribeFromTopic(subscriptionRequestDto);
	    }


	    @PostMapping("/token")
	    public String sendPnsToDevice(@RequestBody NotificationRequest notificationRequestDto) {
	        return notificationService.sendPnsToDevice(notificationRequestDto);
	    }
	    */
	   
}
