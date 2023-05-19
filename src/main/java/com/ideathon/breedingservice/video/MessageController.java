package com.ideathon.breedingservice.video;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


	@MessageMapping("/message")
	@SendToUser("/topic/return-to")
	public String getContent(final Message message, final Principal principal) {
		try {
			Thread.sleep(2000);
		}catch(Exception ex) {
			
		}
		
        //simpMessagingTemplate.convertAndSendToUser(message.getTo(), "/topic/return-to", message);

		return "Sending private message to User: "+message.getTo()+" Message: "+message.getContent();
	}
}
