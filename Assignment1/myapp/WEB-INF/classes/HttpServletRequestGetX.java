import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;

public class HttpServletRequestGetX extends HttpServlet {
	
	public void init() {
		// called only once in the begining by the container to indicate that the servlet is being placed into service
		System.out.println("*** INIT METHOD CALLED ***");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("*** SERVICE METHOD CALLED ***");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<title>HttpServletRequest getX() methods</title>");  
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<h2>Interface HttpServletRequest</h2>");
		out.println("****************************************");
		out.println("<ul>");
		out.println("<li>" + "<b> 	getAuthType(): </b>" + request.getAuthType() + "</li><br/>");
		out.println("<li>" + "<b> 	getCookies(): </b>" + request.getCookies() + "</li><br/>");
		out.println("<li>" + "<b> 	getContextPath(): </b>" + request.getContextPath() + "</li><br/>");
		out.println("<li>" + "<b> 	getPathInfo(): </b>" + request.getPathInfo() + "</li><br/>");
		out.println("<li>" + "<b> 	getSession(true): </b>" + request.getSession(true) + "</li><br/>");
		out.println("<li>" + "<b> 	getPathTranslated(): </b>" + request.getPathTranslated() + "</li><br/>");
		out.println("<li>" + "<b> 	getQueryString(): </b>" + request.getQueryString() + "</li><br/>");
		out.println("<li>" + "<b> 	getRequestedSessionId(): </b>" + request.getRequestedSessionId() + "</li><br/>");
		out.println("<li>" + "<b> 	getRequestURI(): </b>" + request.getRequestURI() + "</li><br/>");
		out.println("<li>" + "<b> 	getRequestURL(): </b>" + request.getRequestURL() + "</li><br/>");
		out.println("<li>" + "<b> 	getMethod(): </b>" + request.getMethod() + "</li><br/>");
		out.println("<li>" + "<b> 	getServletPath(): </b>" + request.getServletPath() + "</li><br/>");
		out.println("<li>" + "<b> 	getSession(): </b>" + request.getSession() + "</li><br/>");
		out.println("<li>" + "<b> 	getUserPrincipal(): </b>" + request.getUserPrincipal() + "</li><br/>");
		out.println("<li>" + "<b> 	getRemoteUser(): </b>" + request.getRemoteUser() + "</li><br/>");
		out.println("<ul>");
		out.println("</BODY>");
		out.println("</HTML>");
	}
	
	public void destroy() {
		// called only once by the servlet container to indicate to a servlet that the servlet is being taken out of service
		System.out.println("*** DESTROY METHOD CALLED ***");
	}
}