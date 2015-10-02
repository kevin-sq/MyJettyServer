package com.cn.server.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handle_req(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handle_req(req, resp);
	}

	private void handle_req(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int size = req.getContentLength();
		System.out.println("len = " + size);

		InputStream is = req.getInputStream();

		byte[] reqBodyBytes = readBytes(is, size);

		String res = new String(reqBodyBytes);

		System.out.println(res);

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter p_writer = resp.getWriter();
		p_writer.println("he,dataBack");
	}

	public static final byte[] readBytes(InputStream is, int contentLen) {
		if (contentLen > 0) {
			int readLen = 0;
			int readLengthThisTime = 0;
			byte[] message = new byte[contentLen];
			try {
				while (readLen != contentLen) {
					readLengthThisTime = is.read(message, readLen, contentLen - readLen);
					if (readLengthThisTime == -1) // Should not happen.
					{
						break;
					}
					readLen += readLengthThisTime;
				}
				return message;
			} catch (IOException e) {
				
			}
		}
		return new byte[] {};
	}
}