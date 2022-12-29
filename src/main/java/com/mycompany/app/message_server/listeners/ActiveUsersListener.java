package com.mycompany.app.message_server.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ActiveUsersListener implements HttpSessionListener {

	public static long counter = 0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		counter++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		counter--;
	}
}
