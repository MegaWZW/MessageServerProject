package com.mycompany.app.message_server.service.api;

import com.mycompany.app.message_server.core.dto.StatisticsResultDTO;

public interface IStatisticsService {
	StatisticsResultDTO getResult();
	long getMessagesAmount();
	long getUsersAmount();
	long getOnlineAmount();
}
