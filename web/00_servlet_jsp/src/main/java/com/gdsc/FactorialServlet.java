package com.gdsc;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.connector.Response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/factorialServlet")
public class FactorialServlet extends HttpServlet{
	
//	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>");
        out.println("<h2>Factorial Table</h2>");
	    out.println("<table border='1'>");
	    out.println("<tr><th>Number</th><th>Factorial</th></tr>");
	      
	    for (int i = 0; i <= 10; i++) {
	       out.println("<tr><td>" + i + "</td><td>" + factorial(i) + "</td></tr>");
	    }

        out.println("</table>");
        out.println("</body></html>");
			
	}

    private long factorial(int n) {
   	 if(n == 0) return 1;
   	 long result = 1;
   	 for(int i = 1; i <= n; i++) {
   		 result *= i;
   	 }
   	 return result; 
    }

}
