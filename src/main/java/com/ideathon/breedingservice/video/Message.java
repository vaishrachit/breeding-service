package com.ideathon.breedingservice.video;


public class Message {
	private String to;
    private String content;
    private String from;
    
	public Message(String from, String content, String to) {
		this.from = from;
		this.to = to;
		this.content = content;
	}
	
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
    
}