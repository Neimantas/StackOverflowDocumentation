
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
import service.ICallBackCheck;
import service.IFileService;
import service.ILanguageService;
import service.ITopicsService;
import service.impl.CallBackCheckImpl;
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
		ICallBackCheck callBack = new CallBackCheckImpl();
		_isCallBack = callBack.postbackControl(request);

		if (_isCallBack) {
			switch (request.getParameter("action")) {
			case "searchButton":
				searchButton(request);
				request.getRequestDispatcher("showdata.jsp").forward(request, response);
				break;
			case "pageCycleButton":
				searchButton(request);
				request.getRequestDispatcher("showdata.jsp").forward(request, response);
				break;
			default:
				System.out.println("Default");
			}
		} else {
			request.getRequestDispatcher("showdata.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	// private void pagination(HttpServletRequest request) {
	//
	//
	// }

	private void searchButton(HttpServletRequest request) throws IOException {
		List<Topic> filteredList = pageCycle(request);
		List<Topic> paginationlist = pagination(request, filteredList);
		request.setAttribute("filteredTopicsList", paginationlist);
	}

	public List<Topic> pageCycle(HttpServletRequest request) throws IOException {
		String language = (request.getParameter("language") != null) ? request.getParameter("language") : "";
		String topic = (request.getParameter("topic") != null) ? request.getParameter("topic") : "";

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

	public List<Topic> pagination(HttpServletRequest request, List<Topic> filteredList) {
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

}
