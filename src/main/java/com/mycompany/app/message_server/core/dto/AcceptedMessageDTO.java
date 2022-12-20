package com.mycompany.app.message_server.core.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class AcceptedMessageDTO {
	private MessageDTO message;
	private LocalDateTime dtAcceptance;

	public AcceptedMessageDTO(MessageDTO message, LocalDateTime dtAcceptance) {
		this.message = message;
		this.dtAcceptance = dtAcceptance;
	}

	public AcceptedMessageDTO(MessageDTO message) {
		this.message = message;
		this.dtAcceptance = LocalDateTime.now();
	}

	public MessageDTO getMessage() {
		return message;
	}

	public void setMessage(MessageDTO message) {
		this.message = message;
	}

	public LocalDateTime getDtAcceptance() {
		return dtAcceptance;
	}

	public void setDtAcceptance(LocalDateTime dtAcceptance) {
		this.dtAcceptance = dtAcceptance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AcceptedMessageDTO that = (AcceptedMessageDTO) o;
		return Objects.equals(message, that.message) && Objects.equals(dtAcceptance, that.dtAcceptance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, dtAcceptance);
	}
}
