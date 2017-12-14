

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.enums.Languages;
import models.java_models.Topic;
import service.IFileService;
import service.ILanguageService;
import service.ITopicsService;
import service.impl.FileServiceImp;
import service.impl.LanguageServiceImpl;
import service.impl.TopicsServiceImpl;

@WebServlet("/Showdata")
public class Showdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Showdata() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loadPage=(request.getParameter("loadPage")!=null) ?
        		request.getParameter("loadPage"): "";
		
		
        		if(!loadPage.isEmpty()) {
        		
//		String language=request.getParameter("language");
//	    String topic=request.getParameter("topic");
	    
	    String language="java";
	    String topic="java";
       
		
		
		URL url = getClass().getResource("/externalSources/topics.json");	
		IFileService fileservice=new FileServiceImp();
		String topicJson=fileservice.getFileContent(url.getPath());
				
       
        ILanguageService langaugeService = new LanguageServiceImpl();
		Languages lang = langaugeService.setEnums(language);
		ITopicsService topicService = new TopicsServiceImpl();
		List<Topic> allTopicList = topicService.getTopics(topicJson);
		
		List<Topic> filteredTopicsList = topicService.findTopicByLanguage(allTopicList, lang, topic);
		
		
		
//		ITopicsService topicsService =new TopicsServiceImpl();
//		List<Topic> listTopics= topicsService.getTopics(topicJson);
//		
//        String page=(request.getParameter("page")!=null) ?
//        		request.getParameter("page"): "";  
//        String current= (request.getParameter("currentpage") != null) ? 
//        		request.getParameter("currentpage") : ""; 
//        
//        int total=10; 
//        int currentpage=(current != null && current=="") ? 1 : Integer.parseInt(current);
//  
//      
//        if (page.equals("up")){  
//        	currentpage=currentpage+total; 
//        }  
//        if (page.equals("down")){  
//        	
//        	currentpage=currentpage-total;
//        	if(currentpage<1) {
//        		currentpage=1;
//        	}
//        }  
//        
//        request.setAttribute("currentpage", currentpage);
        
//        List<Topic> listTopicByPage=topicService.getTopicsByPage(filteredTopicsList, currentpage);  
//  		request.setAttribute("topiclistByPage", listTopicByPage);
  		

    
		request.setAttribute("topiclistByPage", filteredTopicsList);

	    request.getRequestDispatcher("showdata.jsp").forward(request, response);
        		}
        		else {request.getRequestDispatcher("showdata.jsp").forward(request, response);}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("veikia2");
	}
}
