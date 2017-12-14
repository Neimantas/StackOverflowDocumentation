

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
import service.TopicsService;
import service.impl.FileServiceImp;
import service.impl.TopicsServiceImpl;

@WebServlet("/Answer")
public class Answer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Answer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
		
		 response.setContentType("text/html");
		 
		 URL url = getClass().getResource("/externalSources/topics.json");	
			FileServiceImp fileservice=new FileServiceImp();
			String topicJson=fileservice.getFileContent(url.getPath());					
			TopicsService topicsService =new TopicsServiceImpl();
			List<Topic> listTopics= topicsService.getTopics(topicJson);
		 
		 int topicid=Integer.parseInt(request.getParameter("topicid"));
		 
		 String answer=topicsService.getTopicById(listTopics, topicid).getAnswer();
		 String title=topicsService.getTopicById(listTopics, topicid).getTitle();
		 
		 
		 request.setAttribute("topicanswer", answer);
		 request.setAttribute("topictitle", title);
       
	    request.getRequestDispatcher("answer.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("veikia2");
	}
}
