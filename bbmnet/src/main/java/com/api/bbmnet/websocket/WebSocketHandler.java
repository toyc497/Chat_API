package com.api.bbmnet.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class WebSocketHandler implements org.springframework.web.socket.WebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		System.out.println("Conexao Estabelecida");
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		
		 String payload = (String) message.getPayload();
	     session.sendMessage(new TextMessage("Recebi sua mensagem: " + payload));
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		
		System.out.println("ERRO NO TRANSPORTE");
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		
		System.out.println("FECHOU A CONEXAO WS");
		
	}

	@Override
	public boolean supportsPartialMessages() {
		
		return false;
	
	}
	
}
