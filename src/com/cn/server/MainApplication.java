package com.cn.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import com.cn.server.controller.FirstController;

/*
 * 主程序入口
*/

public class MainApplication {
	private final static int SERVER_PORT = 6789;

	/*
	 * 入口方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Server mainServer = new Server(SERVER_PORT);

		ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		contextHandler.setContextPath("/");

		mainServer.setHandler(contextHandler);

		contextHandler.addServlet(new ServletHolder(new FirstController()), "/test");

		mainServer.start();
		mainServer.join();
	}

}