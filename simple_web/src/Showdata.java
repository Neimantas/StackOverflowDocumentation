

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
import service.file.FileService;
import service.impl.TopicsServiceImpl;

@WebServlet("/Showdata")
public class Showdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Showdata() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String language=request.getParameter("language");
	    String topic=request.getParameter("topic");
	    
	    

		
		
		URL url = getClass().getResource("/externalSources/topics.json");	
		FileService fileservice=new FileService();
		String topicJson=fileservice.getFileContent(url.getPath());
				
		TopicsService topicsService =new TopicsServiceImpl();
		List<Topic> listTopics= topicsService.getTopics(topicJson);
		
        String page=(request.getParameter("page")!=null) ?
        		request.getParameter("page"): "";  
        String current= (request.getParameter("currentpage") != null) ? 
        		request.getParameter("currentpage") : ""; 
        
        int total=10; 
        int currentpage=(current != null && current=="") ? 1 : Integer.parseInt(current);
  
      
        if (page.equals("up")){  
        	currentpage=currentpage+total; 
        }  
        if (page.equals("down")){  
        	
        	currentpage=currentpage-total;
        }  
        
        request.setAttribute("currentpage", currentpage);
        
        List<Topic> listTopicByPage=topicsService.getTopicsByPage(listTopics, currentpage);  
//  		request.setAttribute("topiclistByPage", listTopicByPage);
  		

    
		request.setAttribute("topiclist", listTopicByPage);

	    request.getRequestDispatcher("showdata.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("veikia2");
	}
}
