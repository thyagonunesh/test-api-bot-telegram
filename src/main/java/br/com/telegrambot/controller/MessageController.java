package br.com.telegrambot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.telegrambot.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping("/sendMessage/{chatId}/{text}")
	public String sendMessage(@PathVariable String chatId, @PathVariable String text) {
		return messageService.sendMessage(chatId, text);
	}
	
}
