

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

@WebServlet("/LanguageController")
public class LanguageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LanguageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String language = request.getParameter("language");
//		System.out.println(language);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		URL url = getClass().getResource("/externalSources/topics.json");	
		IFileService fileservice=new FileServiceImp();
		String topicJson=fileservice.getFileContent(url.getPath());
		
		String language = request.getParameter("language");
		String topic = request.getParameter("topic");
		
		ILanguageService langaugeService = new LanguageServiceImpl();
		Languages lang = langaugeService.setEnums(language);
		ITopicsService topicService = new TopicsServiceImpl();
		List<Topic> allTopicList = topicService.getTopics(topicJson);
		
		List<Topic> filteredTopicsList = topicService.findTopicByLanguage(allTopicList, lang, topic);
		
		request.setAttribute("topiclist", filteredTopicsList);
	    request.getRequestDispatcher("showdata.jsp").forward(request, response);
		
		System.out.println(language);
		System.out.println(topic);
	}

}
