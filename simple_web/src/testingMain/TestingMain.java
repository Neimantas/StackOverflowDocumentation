package testingMain;

import java.util.Arrays;
import java.util.List;

import models.java_models.DocTagsVersions;
import models.java_models.Topic;
import service.IMockService;
import service.MockService;

public class TestingMain {
	

	
	public static void main(String []args) {
		
		IMockService imockService= new MockService();
		List<DocTagsVersions> list= imockService.getListObject();
		
		list.forEach(s->System.out.println(s.id+s.title));
		
		List<Topic> listTopic= imockService.getListTopic();
		listTopic.forEach(s->System.out.println(s.id+s.title+s.answer));

		
	}

}
