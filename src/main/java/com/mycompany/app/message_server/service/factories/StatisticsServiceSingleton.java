package com.mycompany.app.message_server.service.factories;

import com.mycompany.app.message_server.service.StatisticsService;
import com.mycompany.app.message_server.service.api.IStatisticsService;

public class StatisticsServiceSingleton {
	private volatile static StatisticsService instance;

	private StatisticsServiceSingleton(){}

	public static IStatisticsService getInstance(){
		if (instance == null){
			synchronized (StatisticsServiceSingleton.class){
				if(instance == null){
					instance = new StatisticsService(UserServiceSingleton.getInstance(),
							MessageServiceSingleton.getInstance());
				}
			}
		}
		return instance;
	}
}
