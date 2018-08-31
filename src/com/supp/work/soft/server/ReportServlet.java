package com.supp.work.soft.server;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supp.work.soft.shared.model.Employes;

public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SET_REQUEST = "setRequest";
	private static final String SET_REPONSE = "setResponse";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		String repportName = req.getParameter("reportName");
		try {
			
			
			Class c = null;
			c = Class.forName("com.supp.work.soft.server.rapport."
					+ repportName);
			
			Constructor constructor1;
			constructor1 = c.getConstructor();
			Object constructor = constructor1.newInstance();
			Method _request = constructor.getClass().getDeclaredMethod(
					SET_REQUEST, HttpServletRequest.class);
			_request.invoke(constructor, req);

			Method _response = constructor.getClass().getDeclaredMethod(
					SET_REPONSE, HttpServletResponse.class);
			_response.invoke(constructor, resp);
			
			
			
			if(session!=null){
				Method _filters = constructor.getClass().getDeclaredMethod(
						"setList", List.class);	
				if(session.getAttribute("employeList")!=null){
				
					_filters.invoke(constructor,(List<Employes>)session.getAttribute("employeList"));	
				}else{
//					System.out.println("logging============");
//					 constructor.getClass().getDeclaredMethod(
//							"clearFilters").invoke(constructor);
					
				}
				
				
				/*Method _fil = constructor.getClass().getDeclaredMethod(
						"setFilters", String.class);	
				if(session.getAttribute("defaultUser_classeFilter")!=null){
					_fil.invoke(constructor,(String)session.getAttribute("defaultUser_classeFilter"));
						
				}else{
					
//					 constructor.getClass().getDeclaredMethod(
//							"clearFilters").invoke(constructor);
					
				}*/
				
				
			}
			
			constructor.getClass().getDeclaredMethod("buildReport")
					.invoke(constructor);
			session.setAttribute("defaultUser_filter", null);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block

			System.out.println(e.toString());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block

			System.out.println(e.toString());
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block

			System.out.println(e.toString());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			System.out.println(e.toString());
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block

			System.out.println(e.toString());
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block

			System.out.println(e.toString());
			e.printStackTrace();
		} 
	}

}
