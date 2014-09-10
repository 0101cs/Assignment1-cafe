package edu.nku.csc456.cafe;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CafeServlet extends HttpServlet {	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		int taxRate = Integer.parseInt(request.getParameter("tax"));
		String[] order = request.getParameterValues("items");
		Receipt rec = new Receipt( order, taxRate );
		
		PrintWriter out = response.getWriter();
		out.append("<html> " +
			    "<body>"+
			    "<h4>Thanks for your shopping!<br/><br/>Here is your receipt</h4><br/><br/>" + 
				"<p>=====================</p> <br/>");
		out.append(rec.displayReceipt());
				
		out.append("<br/><br/>" + 
				"<p>=====================</p> <br/>");
		
				
			
	}
}