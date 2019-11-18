package com.darren;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/encoding")
public class EncodingServlet extends HttpServlet {

	/**
	 * GET 亂碼解決 => 在 %TOMCAT_HOME%\conf\server.xml 中， 找到 <connector port=”8080″ …
	 * 部分，加上 URIEncoding = “UTF-8”， 重啟 Tomcat。
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("nameGet");
		System.out.println("GET: " + name);
		System.out.println(Charset.defaultCharset());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("BIG5");
		String name = request.getParameter("nameGet");
		System.out.println("POST: " + name);
	}

}
