package com.yychat.model;

public class Message {
   private String sender;
   private String receiver;
   //private String content;
   private String messageType;
   
public String getSender() {
	return sender;
}
public void setSender(String sender) {
	this.sender = sender;
}
public String getMessageType() {
	return messageType;
}
public void setMessageType(String messageType) {
	this.messageType = messageType;
}
   
   
}
