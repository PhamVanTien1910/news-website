package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class MessageUtil {
	
	public static void showMessage(HttpServletRequest request) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
		if (request.getParameter("message") != null) {
			String messageResponse = "";
			String alert = "";
			String message = request.getParameter("message");
			if (message.equals("insert_success")) {
				messageResponse = resourceBundle.getString(message);
				alert = "success";
			} else if (message.equals("update_success")) {
				messageResponse = resourceBundle.getString(message);
				alert = "success";
			} else if (message.equals("delete_success")) {
				messageResponse = resourceBundle.getString(message);
				alert = "success";
			} else if (message.equals("error_system")) {
				messageResponse = resourceBundle.getString(message);
				alert = "danger";
			}
			request.setAttribute("messageResponse", messageResponse);
			request.setAttribute("alert", alert);
		}
	}
}
