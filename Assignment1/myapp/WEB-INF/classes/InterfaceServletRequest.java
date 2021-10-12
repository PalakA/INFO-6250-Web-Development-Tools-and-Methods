import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.*;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import java.util.Enumeration;

public class InterfaceServletRequest extends HttpServlet {
	
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
		out.println("<title>Interface ServletRequest getX() methods</title>");  
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<h2>Interface ServletRequest</h2>");
		out.println("****************************************");
		out.println("<ul>");
		out.println("<li>" + "<b> 	getCharacterEncoding(): </b>" + request.getCharacterEncoding() + "</li><br/>");
		out.println("<li>" + "<b> 	getRemoteHost(): </b>" + request.getRemoteHost() + "</li><br/>");
		out.println("<li>" + "<b> 	getContentLengthLong(): </b>" + request.getContentLengthLong() + "</li><br/>");
		out.println("<li>" + "<b> 	getDispatcherType(): </b>" + request.getDispatcherType() + "</li><br/>");
		out.println("<li>" + "<b> 	getContentLength(): </b>" + request.getContentLength() + "</li><br/>");
		out.println("<li>" + "<b> 	getInputStream(): </b>" + request.getInputStream() + "</li><br/>");
		out.println("<li>" + "<b> 	getLocalAddr(): </b>" + request.getLocalAddr() + "</li><br/>");
		out.println("<li>" + "<b> 	getContentType(): </b>" + request.getContentType() + "</li><br/>");
		out.println("<li>" + "<b> 	getLocale(): </b>" + request.getLocale() + "</li><br/>");
		out.println("<li>" + "<b> 	getLocalName(): </b>" + request.getLocalName() + "</li><br/>");
		out.println("<li>" + "<b> 	getProtocol(): </b>" + request.getProtocol() + "</li><br/>");
		out.println("<li>" + "<b> 	getReader(): </b>" + request.getReader() + "</li><br/>");
		out.println("<li>" + "<b> 	getLocalPort(): </b>" + request.getLocalPort() + "</li><br/>");
		out.println("<li>" + "<b> 	getRemoteAddr(): </b>" + request.getRemoteAddr() + "</li><br/>");
		out.println("</ul>");
		out.println("</BODY>");
		out.println("</HTML>");
	}
	
	public void destroy() {
		// called only once by the servlet container to indicate to a servlet that the servlet is being taken out of service
		System.out.println("*** DESTROY METHOD CALLED ***");
	}
}