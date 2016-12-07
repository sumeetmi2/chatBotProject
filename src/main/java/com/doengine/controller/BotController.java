/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Nov 4, 2016
 */
package com.doengine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doengine.common.CommonConstants;
import com.doengine.objects.Bot;
import com.doengine.objects.Chat;
import com.doengine.services.BotService;
import com.doengine.wit.misc.WitConstants;

/**
 * @author SumeetS
 *
 */
@Service
@RequestMapping(value = "/bot")
public class BotController extends BaseController {

    @Autowired
    BotService botService;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView parse(@ModelAttribute("bot") Bot bot, ModelMap map, HttpServletRequest httpServletRequest,HttpServletResponse response) {
	try {
	    String parsedContent = botService.parse(bot);
	    if (bot.getCurrentChat().getMessage() != null && bot.getCurrentChat().getMessage().length() > 0) {
		bot.addChatToConversation(bot.getCurrentChat());
	    }
	    if (bot.getActionType().equals(WitConstants.ACTION)) {
		httpServletRequest.setAttribute("redirect", "1");
	    } else {
		if (bot.getActionType().equals(WitConstants.FEEDBACK)) {
			httpServletRequest.setAttribute("feedbackFlag", "1");
		} 
		Chat botResponse = new Chat();
		botResponse.setMessage(parsedContent);
		botResponse.setId("Bot");
		bot.addChatToConversation(botResponse);
	    }
	    bot.setCurrentChat(null);
	    response.setHeader("X-XSS-Protection","0");
	    map.addAttribute("chats", bot.getChats());
	} catch (Exception e) {
	    return new ModelAndView("error");
	}

	return new ModelAndView("chatBotUI", "command", bot);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getBotUI() {
	Bot bot = new Bot(System.currentTimeMillis());
	bot.setResponse(CommonConstants.BOT_CONVERSATION_INIT_FLAG);
	return new ModelAndView("chatBotUI", "command", bot);
    }
}
