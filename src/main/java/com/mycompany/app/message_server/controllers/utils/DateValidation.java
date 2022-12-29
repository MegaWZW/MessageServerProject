package com.mycompany.app.message_server.controllers.utils;

public class DateValidation {

	public static void validate (Integer year, Integer month, Integer day){
		if(year > 2022 || year < 1900){
			throw new IllegalArgumentException("Передан недопустимый год");
		}

		if(month < 1 || month > 12){
			throw new IllegalArgumentException("Передан недопустимый месяц");
		}

		if (day > 31 || day < 1){
			throw new IllegalArgumentException("Передан недопустимый день");
		}
	}
}
