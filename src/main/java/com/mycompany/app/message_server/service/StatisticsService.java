package com.mycompany.app.message_server.service;

import com.mycompany.app.message_server.core.dto.StatisticsResultDTO;
import com.mycompany.app.message_server.listeners.ActiveUsersListener;
import com.mycompany.app.message_server.service.api.IMessageService;
import com.mycompany.app.message_server.service.api.IStatisticsService;
import com.mycompany.app.message_server.service.api.IUserService;

public class StatisticsService implements IStatisticsService {

	private final IUserService userService;
	private final IMessageService messageService;


	public StatisticsService(IUserService userService, IMessageService messageService) {
		this.userService = userService;
		this.messageService = messageService;
	}

	@Override
	public StatisticsResultDTO getResult() {
		return new StatisticsResultDTO(getUsersAmount(), getMessagesAmount(), getOnlineAmount());
	}

	@Override
	public long getMessagesAmount() {
		return this.messageService.getMessages().size();
	}

	@Override
	public long getUsersAmount() {
		return this.userService.getUsers().size();
	}

	@Override
	public long getOnlineAmount() {
		return ActiveUsersListener.getCounter();
	}

}
