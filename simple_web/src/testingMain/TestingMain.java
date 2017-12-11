package testingMain;

import java.util.List;

import models.java_models.DocTagsVersions;
import models.java_models.Examples;
import models.java_models.Topic;
import service.IMockService;
import service.MockService;

public class TestingMain {
	

	
	public static void main(String []args) {
		
		IMockService imockService= new MockService();
		List<DocTagsVersions> list= imockService.getListObject();
		
		list.forEach(s->System.out.println(s.id+s.title));
		
//		List<Topic> listTopic= imockService.getListTopic();
//		listTopic.forEach(s->System.out.println(s.id+s.title+s.answer));
//		
//		List<Examples> listExamples = imockService.getListExample();
//		listExamples.forEach(s->System.out.println(s.id+s.description+s.docTopicId.title+s.docTopicId.docTagId.title));		
	}

}
