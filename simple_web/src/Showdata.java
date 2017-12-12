

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.java_models.DocTagsVersions;
import models.java_models.Topic;
import service.ConverterJsonService;
import service.FileService;
import service.MockService;
import service.TopicsDao;
import service.impl.TopicsDaoImpl;

@WebServlet("/Showdata")
public class Showdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Showdata() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("veikia");
//		MockService mockService = new MockService();
//		List<DocTagsVersions> list =  mockService.getListObject();
//		request.setAttribute("listas", list);
//		
		FileService fileservice=new FileService();
		File file = new File("C:\\Users\\Dainius\\Documents\\StackOverflowDocumentation\\simple_web\\src\\externalSources\\topics.json");
		String topicjson=fileservice.getFileContent(file);
				
		TopicsDao topicsDao=new TopicsDaoImpl();
		List<Topic> listTopics=topicsDao.getTopics(topicjson);
		request.setAttribute("topiclist", listTopics);

	    request.getRequestDispatcher("showdata.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("veikia2");
	}
}
