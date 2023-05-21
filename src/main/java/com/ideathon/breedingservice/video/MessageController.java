package com.ideathon.breedingservice.video;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MessageController {
	
	@Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


	@MessageMapping("/message")
	public Message getContent(@Payload Message message, final Principal principal) {
		
        simpMessagingTemplate.convertAndSendToUser(message.getTo(), "/topic/return-to", message);

		return message;
	}
}
