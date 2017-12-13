

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.java_models.Topic;
import service.file.FileService;
import service.TopicsService;
import service.impl.TopicsServiceImpl;

@WebServlet("/Showdata")
public class Showdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Showdata() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL url = getClass().getResource("/externalSources/topics.json");	
		FileService fileservice=new FileService();
		String topicJson=fileservice.getFileContent(url.getPath());
				
		TopicsService topicsService =new TopicsServiceImpl();
		List<Topic> listTopics= topicsService.getTopics(topicJson);
		request.setAttribute("topiclist", listTopics);

	    request.getRequestDispatcher("showdata.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("veikia2");
	}
}
