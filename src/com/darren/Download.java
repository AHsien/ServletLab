package com.darren;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		if ("12345".equals(password)) {
			// 設定內容類型
			response.setContentType("application/pdf");
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/handbook.pdf");

			OutputStream out = response.getOutputStream();
			writeBytes(in, out);
		}
	}

	private void writeBytes(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int length = -1;
		while ((length = in.read(buffer)) != -1) {
			out.write(buffer, 0, length);
		}
		in.close();
		out.flush();
		out.close();
	}

}
