package com.darren;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(location = "/Users/darren/Pictures/")
@WebServlet("/upload2.do")
public class UploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Part part = request.getPart("photo");
		String filename = getFilename(part);
		part.write(filename);
	}

	private String getFilename(Part part) {
		String header = part.getHeader("Content-Disposition");
		return header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
	}

}
