package com.mycompany.app.message_server.core.dto;

import java.util.Objects;

public class StatisticsResultDTO {
	private long usersAmount;
	private long messagesAmount;
	private long usersOnline;

	public StatisticsResultDTO(long usersAmount, long messagesAmount, long usersOnline) {
		this.usersAmount = usersAmount;
		this.messagesAmount = messagesAmount;
		this.usersOnline = usersOnline;
	}

	public long getUsersAmount() {
		return usersAmount;
	}

	public void setUsersAmount(long usersAmount) {
		this.usersAmount = usersAmount;
	}

	public long getMessagesAmount() {
		return messagesAmount;
	}

	public void setMessagesAmount(long messagesAmount) {
		this.messagesAmount = messagesAmount;
	}

	public long getUsersOnline() {
		return usersOnline;
	}

	public void setUsersOnline(long usersOnline) {
		this.usersOnline = usersOnline;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StatisticsResultDTO that = (StatisticsResultDTO) o;
		return usersAmount == that.usersAmount && messagesAmount == that.messagesAmount && usersOnline == that.usersOnline;
	}

	@Override
	public int hashCode() {
		return Objects.hash(usersAmount, messagesAmount, usersOnline);
	}

	@Override
	public String toString() {
		return "StatisticsResultDTO{" +
				"usersAmount=" + usersAmount +
				", messagesAmount=" + messagesAmount +
				", usersOnline=" + usersOnline +
				'}';
	}
}
