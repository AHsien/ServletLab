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
@WebServlet("/upload3.do")
public class UploadServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		for (Part part : request.getParts()) {
			if (part.getName().startsWith("file")) {
				String filename = getFilename(part);
				part.write(filename);
			}
		}

	}

	private String getFilename(Part part) {
		String header = part.getHeader("Content-Disposition");
		return header.substring( //
				header.indexOf("filename=\"") + 10, //
				header.lastIndexOf("\""));
	}

}
