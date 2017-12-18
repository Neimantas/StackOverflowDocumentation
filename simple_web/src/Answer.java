

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.java_models.Examples;
import models.java_models.Topic;
import service.IExampleService;
import service.IFileService;
import service.ITopicsService;
import service.impl.ExampleServiceImpl;
import service.impl.FileServiceImp;
import service.impl.TopicsServiceImpl;

@WebServlet("/Answer")
public class Answer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Answer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loadPage=(request.getParameter("loadPage")!=null) ?
        		request.getParameter("loadPage"): "";
        int topicid=Integer.parseInt(request.getParameter("topicid"));
        if(!loadPage.isEmpty()) {
        	URL url = getClass().getResource("/externalSources/examples.json");	
			IFileService fileservice=new FileServiceImp();
			String topicJson=fileservice.getFileContent(url.getPath());	
			
			IExampleService exampleService = new ExampleServiceImpl();
			List<Examples> examplesList = exampleService.getExampleList(topicJson);
			List<Examples> examplesListByTopic = exampleService.getExampleByTipicId(examplesList,(long) topicid);
			request.setAttribute("exampleList", examplesListByTopic);
			request.getRequestDispatcher("example.jsp").forward(request, response);
        }
        		
        if(loadPage.isEmpty()) {		
		
		 response.setContentType("text/html");
		 
		 URL url = getClass().getResource("/externalSources/topics.json");	
			IFileService fileservice=new FileServiceImp();
			String topicJson=fileservice.getFileContent(url.getPath());					
			ITopicsService topicsService =new TopicsServiceImpl();
			List<Topic> listTopics= topicsService.getTopics(topicJson);
		 
		 
		 
		 String answer=topicsService.getTopicById(listTopics, topicid).getAnswer();
		 String title=topicsService.getTopicById(listTopics, topicid).getTitle();
		 
		 
		 request.setAttribute("topicanswer", answer);
		 request.setAttribute("topictitle", title);
		 request.setAttribute("topicid", topicid);
	    request.getRequestDispatcher("answer.jsp").forward(request, response);
        		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("veikia2");
	}
}
