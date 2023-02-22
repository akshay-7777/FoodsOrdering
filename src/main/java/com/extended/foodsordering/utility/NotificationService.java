package com.extended.foodsordering.utility;

import org.springframework.stereotype.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;

import com.extended.foodsordering.bean.NotificationRequest;
import com.extended.foodsordering.bean.SubscriptionRequest;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import jakarta.annotation.PostConstruct;
@Service
public class NotificationService {

	    @Value("${app.firebase-config}")
	    private String firebaseConfig;

	    
	    private FirebaseApp firebaseApp;

	    @PostConstruct
	    private void initialize() {
	        try {
	            FirebaseOptions options = new FirebaseOptions.Builder()
	                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(firebaseConfig).getInputStream())).build();

	            if (FirebaseApp.getApps().isEmpty()) {
	                this.firebaseApp = FirebaseApp.initializeApp(options);
	            } else {
	                this.firebaseApp = FirebaseApp.getInstance();
	            }
	        } catch (IOException e) {
	        	System.out.println("Create FirebaseApp Error"+e);
	        }
	    }
	    
	    public String sendPnsToTopic(NotificationRequest notificationRequestDto) {
	        Message message = Message.builder().setTopic(notificationRequestDto.getTarget())
	                .setNotification(new Notification(notificationRequestDto.getTitle(), notificationRequestDto.getBody()))
	                .putData("content", notificationRequestDto.getTitle()) .putData("body", notificationRequestDto.getBody())
	                .build();

	        String response = null;
	        try {
	        	response = FirebaseMessaging.getInstance().send(message);
	            System.out.println(response);
	            System.out.println("msg is send");
	        } catch (FirebaseMessagingException e) {
	        	System.out.println("Fail to send firebase notification"+e);
	        }

	        return response;
	    }
	      	    
	    /*
	    public void subscribeToTopic(SubscriptionRequest subscriptionRequestDto) {
	        try {
	            FirebaseMessaging.getInstance(firebaseApp).subscribeToTopic(subscriptionRequestDto.getTokens(),
	                    subscriptionRequestDto.getTopicName());
	        } catch (FirebaseMessagingException e) {
	            System.out.println("Firebase subscribe to topic fail"+e);
	        }
	    }

	    public void unsubscribeFromTopic(SubscriptionRequest subscriptionRequestDto) {
	        try {
	            FirebaseMessaging.getInstance(firebaseApp).unsubscribeFromTopic(subscriptionRequestDto.getTokens(),
	                    subscriptionRequestDto.getTopicName());
	        } catch (FirebaseMessagingException e) {
	        	System.out.println("Firebase unsubscribe from topic fail"+e);
	        }
	    }

	    public String sendPnsToDevice(NotificationRequest notificationRequestDto) {
	        Message message = Message.builder()
	                .setToken(notificationRequestDto.getTarget())
	                .setNotification(new Notification(notificationRequestDto.getTitle(), notificationRequestDto.getBody()))
	                .putData("content", notificationRequestDto.getTitle())
	                .putData("body", notificationRequestDto.getBody())
	                .build();

	        String response = null;
	        try {
	            response = FirebaseMessaging.getInstance().send(message);
	        } catch (FirebaseMessagingException e) {
	        	System.out.println("Fail to send firebase notification"+e);
	        }

	        return response;
	    }

	  */
}
