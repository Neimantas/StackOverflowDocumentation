

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.java_models.DocTagsVersions;
import service.MockService;

@WebServlet("/Showdata")
public class Showdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Showdata() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("veikia");
//		MockService mockService = new MockService();
//		List<DocTagsVersions> list =  mockService.getListObject();
//		request.setAttribute("listas", list);
		
		List<Integer> intList = new ArrayList();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		request.setAttribute("listas", intList);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    request.getRequestDispatcher("showdata.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("veikia2");
	}
}
