package com.ideathon.breedingservice.video;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
	
	@Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

	
	@MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message){
        return message;
    }


	@MessageMapping("/private-message")
	public Message getContent(@Payload Message message, final Principal principal) {
		
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);

		return message;
	}
}
