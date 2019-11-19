package com.darren;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

// Tomcat 中必須設定此標註才能使用 getPart() 相關 API
@MultipartConfig
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part part = request.getPart("photo");
		String fileName = getFileName(part);
		writeTo(fileName, part);
	}

	private String getFileName(Part part) {
		String header = part.getHeader("Content-Disposition");
		return header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
	}

	private void writeTo(String fileName, Part part) throws IOException {
		InputStream in = part.getInputStream();
		OutputStream out = new FileOutputStream("/Users/darren/Pictures/" + fileName);
		byte[] buffer = new byte[1024];
		int length = -1;
		while ((length = in.read(buffer)) != -1) {
			out.write(buffer, 0, length);
		}
		in.close();
		out.close();
	}

}
