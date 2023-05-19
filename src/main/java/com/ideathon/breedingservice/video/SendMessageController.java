package com.ideathon.breedingservice.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

	@Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

	@PostMapping("/sendMessage/{id}")
	public void sendPrivateMessage(@PathVariable String id, @RequestBody Message message) {
		simpMessagingTemplate.convertAndSendToUser(id , "/topic/return-to", message);
	}
}
