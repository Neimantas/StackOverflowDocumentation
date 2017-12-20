
import java.io.IOException;
import java.net.URL;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
public class Showdata extends HttpServletExtended {
	private static final long serialVersionUID = 1L;
	

	public Showdata() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		if (isCallback(request)) {
			switch (request.getParameter("action")) {
			case "searchButton":
				searchButton(request);
				request.getRequestDispatcher("showdata.jsp").forward(request, response);
				break;
			case "pageCycleButton":
				pageCycleButton(request);
				request.getRequestDispatcher("showdata.jsp").forward(request, response);
				break;
			default:
				System.out.println("Default");
			}
		} else {
			request.setAttribute("pageCount", 0);
			request.setAttribute("FrontEndCurrentPage", 0);
			request.getRequestDispatcher("showdata.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	
	public List<Topic> searchButton(HttpServletRequest request) throws IOException {
		List<Topic> filteredList = pageCycle(request);
		int pageCount = (filteredList.size() % 12 == 0)?(filteredList.size() / 12):(filteredList.size() / 12 + 1);
		List<Topic> paginationlist = pagination(request, filteredList);
		request.setAttribute("filteredTopicsList", paginationlist);
		request.setAttribute("pageCount", pageCount);
		return filteredList;
	}
	
	public void pageCycleButton(HttpServletRequest request)	throws IOException {
		List<Topic> filteredList = searchButton(request);
		
		int pageCount = (filteredList.size() % 12 == 0)?(filteredList.size() / 12):(filteredList.size() / 12 + 1);
		List<Topic> paginationlist = pagination(request, filteredList);
		request.setAttribute("filteredTopicsList", paginationlist);
		request.setAttribute("pageCount", pageCount);
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

		int total = 12;
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
		request.setAttribute("FrontEndCurrentPage", (currentpage - 1) / 12 + 1);
		ITopicsService topicService = new TopicsServiceImpl();

		List<Topic> listTopicByPage = topicService.getTopicsByPage(filteredList, currentpage);

		return listTopicByPage;
	}

}
