package com.mycompany.app.message_server.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener
public class ActiveUsersListener implements HttpSessionAttributeListener {

	private static long counter = 0;

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		if (session.getAttribute("user") != null) {
			counter++;
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if (counter > 0){
			counter--;
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {

	}

	public static long getCounter(){
		return counter;
	}
}
