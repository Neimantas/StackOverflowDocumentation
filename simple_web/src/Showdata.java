
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
	private boolean _isCallBack = false;

	public Showdata() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		postbackControl(request);
		
		System.out.println(request.getParameter("language"));
		System.out.println(_isCallBack);

		if (_isCallBack) {
			List<Topic> filteredList=pageCycle(request);
			
			List<Topic> paginationlist=pagination(request, filteredList);

			request.setAttribute("filteredTopicsList", paginationlist);
			request.getRequestDispatcher("showdata.jsp").forward(request, response);
		}

		else {
			request.getRequestDispatcher("showdata.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
	
	public List<Topic> pageCycle(HttpServletRequest request) throws IOException {
		
		String language = (request.getParameter("language")!=null)?request.getParameter("language"):"";
		
		String topic = request.getParameter("topic");

		URL url = getClass().getResource("/externalSources/topics.json");
		IFileService fileservice = new FileServiceImp();
		String topicJson = fileservice.getFileContent(url.getPath());

		ILanguageService langaugeService = new LanguageServiceImpl();
		Languages lang = langaugeService.setEnums(language);
		ITopicsService topicService = new TopicsServiceImpl();
		List<Topic> allTopicList = topicService.getTopics(topicJson);
		List<Topic> filteredTopicsList = topicService.findTopicByLanguage(allTopicList, lang, topic);
		
		return filteredTopicsList;

	}
	
	public List<Topic> pagination(HttpServletRequest request,  List<Topic> filteredList) {
		
		String page = (request.getParameter("page") != null) ? request.getParameter("page") : "";
		String current = (request.getParameter("currentpage") != null) ? request.getParameter("currentpage") : "";

		int total = 10;
		int currentpage = (current != null && current == "") ? 1 : Integer.parseInt(current);

		if (page.equals("up")) {
			currentpage = currentpage + total;
		}
		if (page.equals("down")) {
			currentpage = currentpage - total;
			if (currentpage < 1) {
				currentpage = 1;
			}
		}

		request.setAttribute("currentpage", currentpage);
		ITopicsService topicService = new TopicsServiceImpl();
		
		List<Topic> listTopicByPage = topicService.getTopicsByPage(filteredList, currentpage);
		
		return listTopicByPage;
		
	}
	
	void postbackControl(HttpServletRequest request) {
		_isCallBack = (request != null && request.getParameter("postBack") == null 
				|| request != null && request.getParameter("postBack") == "") 
				? false : true;
	}
	
	
}
