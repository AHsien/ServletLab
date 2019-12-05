package com.darren;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/scopeAttribute.view")
public class ScopeAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Default attribute:");

		Enumeration<String> enumeration = request.getAttributeNames();
		while (enumeration.hasMoreElements()) {
			String name = enumeration.nextElement();
			if (!name.equals("userName")) {
				out.println(name + " = " + request.getAttribute(name));
			}
		}
		out.println();
		out.println("request scope attribute userName = " + request.getAttribute("userName"));
	}

}
