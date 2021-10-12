import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;

public class Headers extends HttpServlet {
	
	public void init() {
		// called only once in the begining by the container to indicate that the servlet is being placed into service
		System.out.println("*** INIT METHOD CALLED ***");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("*** SERVICE METHOD CALLED ***");
		Enumeration<String> enumHeaders = request.getHeaders("host");
		Enumeration<String> enumHeaders1 = request.getHeaderNames();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<title>Request Headers</title>");
		out.println("<h2>Enumeration getHeaderNames() display:</h2>");
		out.println("<ul>");
		while (enumHeaders.hasMoreElements()) {
			String headerName = (String) enumHeaders.nextElement();
			out.print("<li>" + "<b>HeaderName :</b> ");	
			out.print(headerName);
		}
		out.println("</ul>");
		out.println("**************************************************************");
		out.println("<h2>Enumeration getHeaders(String name) display:</h2>");
		out.println("<ul>");
        while (enumHeaders1.hasMoreElements()) {  
			String headerName = (String) enumHeaders1.nextElement();  
			String headerValue = request.getHeader(headerName);  
			out.print("<li>" + "<b>"+headerName + " :</b>");  
			out.println("&nbsp;&nbsp;" +headerValue + "<br>");
		}
		out.println("</ul>");
		out.println("</BODY>");
		out.println("</HTML>");
	}
	
	public void destroy() {
		// called only once by the servlet container to indicate to a servlet that the servlet is being taken out of service
		System.out.println("*** DESTROY METHOD CALLED ***");
	}
}