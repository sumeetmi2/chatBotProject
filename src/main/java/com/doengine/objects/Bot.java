/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Nov 29, 2016
 */
package com.doengine.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SumeetS
 *
 */
public class Bot {
    private List<Chat> chats = new ArrayList<>();
    private Chat currentChat;
    private long sessionId;
    private String response;
    private String actionType;
    private String feedbackIntent;
    private String feedbackExpression;

    /**
     * @return the feedbackExpression
     */
    public String getFeedbackExpression() {
	return feedbackExpression;
    }

    /**
     * @param feedbackExpression
     *        the feedbackExpression to set
     */
    public void setFeedbackExpression(String feedbackExpression) {
	this.feedbackExpression = feedbackExpression;
    }

    /**
     * @return the feedbackIntent
     */
    public String getFeedbackIntent() {
	return feedbackIntent;
    }

    /**
     * @param feedbackIntent
     *        the feedbackIntent to set
     */
    public void setFeedbackIntent(String feedbackIntent) {
	this.feedbackIntent = feedbackIntent;
    }

    /**
     * @return the actionType
     */
    public String getActionType() {
	return actionType;
    }

    /**
     * @param actionType
     *        the actionType to set
     */
    public void setActionType(String actionType) {
	this.actionType = actionType;
    }

    /**
     * @return the response
     */
    public String getResponse() {
	return response;
    }

    /**
     * @param response
     *        the response to set
     */
    public void setResponse(String response) {
	this.response = response;
    }

    public Bot() {

    }

    public Bot(long sessionId) {
	this.sessionId = sessionId;
    }

    /**
     * @param chats
     *        the chats to set
     */
    public void setChats(List<Chat> chats) {
	this.chats = chats;
    }

    /**
     * @param sessionId
     *        the sessionId to set
     */
    public void setSessionId(long sessionId) {
	this.sessionId = sessionId;
    }

    /**
     * @return the sessionId
     */
    public long getSessionId() {
	return sessionId;
    }

    /**
     * @return the currentChat
     */
    public Chat getCurrentChat() {
	return currentChat;
    }

    /**
     * @param currentChat
     *        the currentChat to set
     */
    public void setCurrentChat(Chat currentChat) {
	this.currentChat = currentChat;
    }

    /**
     * @return the chats
     */
    public List<Chat> getChats() {
	return chats;
    }

    /**
     * @param chats
     *        the chats to set
     */
    public void setChats(ArrayList<Chat> chats) {
	this.chats = chats;
    }

    public void addChatToConversation(Chat chat) {
	this.chats.add(chat);
    }

    /**
     * @param chats2
     */
    public void addChatToConversation(List<Chat> chats2) {
	this.chats.addAll(chats2);
    }
    
}
