package br.com.telegrambot.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MessageService {

	private String botToken = "6133668240:AAGeosh52W9nN3EdVCIoXavfD6dI8ncbIsc";

	public String sendMessage(String chatId, String text) {
		
		String baseUrl = "https://api.telegram.org/bot" + botToken + "/";
		String path = "sendMessage";
		RestTemplate restTemplate = new RestTemplate();
		String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
								.path(path)
								.queryParam("chat_id", chatId)
								.queryParam("text", text)
								.toUriString();
		URI uri = null;
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		ResponseEntity<String> responseEntity =  restTemplate.getForEntity(uri,  String.class);
		return responseEntity.getBody();
	}
	
}
