package com.darren;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseBuffer.view")
public class ResponseBuffer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getBufferSize()
		// response.setBufferSize()
		// response.isCommitted()
		// response.reset()
		// response.resetBuffer()
		// response.flushBuffer()
		// 以上有關緩衝的方法需在 response.getWriter() 或 response.getOutputStrem() 前執行
		// response.setBufferSize() 會拋出 IllegalStateException

		// 要接收中文請求參數或回應時於瀏覽器顯示中文，必須同時設定 request.setCharacterEncoding()
		// 及 response.setCharacterEncoding() 或 setContentType()

		// 設定回應類型及編碼
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
	}
}
