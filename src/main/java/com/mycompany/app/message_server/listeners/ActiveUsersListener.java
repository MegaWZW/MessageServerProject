package com.mycompany.app.message_server.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicLong;

@WebListener
public class ActiveUsersListener implements HttpSessionListener {

	private volatile static AtomicLong counter = new AtomicLong();

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		if(session.getAttribute("user") != null){
			counter.incrementAndGet();
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		if(session.getAttribute("user") != null){
			counter.decrementAndGet();
		}
	}

	public long getCounter() {
		return counter.get();
	}
}
