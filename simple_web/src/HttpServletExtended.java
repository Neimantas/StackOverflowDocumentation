import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletExtended extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public HttpServletExtended() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			 	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
	
	public boolean isCallback(HttpServletRequest request) {
		return (request != null && request.getParameter("postBack") == null 
				|| request != null && request.getParameter("postBack") == "") 
				? false : true;
	}

}
