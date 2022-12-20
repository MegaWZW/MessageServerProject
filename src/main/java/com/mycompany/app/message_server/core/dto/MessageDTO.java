package com.mycompany.app.message_server.core.dto;

import java.util.Objects;

public class MessageDTO {
	private RegisteredUserDTO from;
	private RegisteredUserDTO to;
	String text;

	public MessageDTO(RegisteredUserDTO from, RegisteredUserDTO to, String text) {
		this.from = from;
		this.to = to;
		this.text = text;
	}

	public RegisteredUserDTO getFrom() {
		return from;
	}

	public void setFrom(RegisteredUserDTO from) {
		this.from = from;
	}

	public RegisteredUserDTO getTo() {
		return to;
	}

	public void setTo(RegisteredUserDTO to) {
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MessageDTO that = (MessageDTO) o;
		return Objects.equals(from, that.from) && Objects.equals(to, that.to) && Objects.equals(text, that.text);
	}

	@Override
	public int hashCode() {
		return Objects.hash(from, to, text);
	}
}
