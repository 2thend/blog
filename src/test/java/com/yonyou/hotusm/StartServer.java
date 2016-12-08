//package com.yonyou.hotusm;
//
//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.webapp.WebAppContext;
//
//public class StartServer {
//	
//	public static void main(String[] args) {
//		 Server server = new Server(8080);  
//		  
//	        WebAppContext context = new WebAppContext();  
//	        context.setContextPath("/blog");  
//	        context.setDescriptor("D:/jeesite/blog/src/main/webapp/WEB-INF/web.xml");  
//	        context.setResourceBase("D:/jeesite/blog");  
//	        context.setParentLoaderPriority(true);  
//	        server.setHandler(context);  
//	  
//	        try {
//				server.start();
//				server.join(); 
//			} catch (Exception e) {
//				e.printStackTrace();
//			}  
//	         
//        
//        
//	}
//}
