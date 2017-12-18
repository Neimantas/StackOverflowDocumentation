package testingMain;

import java.io.File;
import java.io.IOException;
import java.util.List;

import database.SQLiteJDBCDriverConnection;
import models.enums.Languages;
import models.java_models.DocTags;
import models.java_models.DocTagsVersions;
import models.java_models.Examples;
import models.java_models.Topic;
import service.IMockService;
import service.ILanguageSearchService;
import service.impl.DocTagsServiceImpl;
import service.impl.ExampleServiceImpl;
import service.impl.FileServiceImp;
import service.impl.MockService;
import service.impl.TopicsServiceImpl;

public class TestingMain {


    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
    	
    	SQLiteJDBCDriverConnection.connect();

//		IMockService imockService= new MockService();
//		List<DocTagsVersions> list= imockService.getListObject();
//
//		list.forEach(s->System.out.println(s.id+s.title));

//        FileServiceImp fileService = new FileServiceImp();
//        String json = fileService.getFileContent("C:\\Users\\Simas\\Documents\\StackOverflowDocumentation\\simple_web\\src\\externalSources\\examples.json");
//
//        TopicsServiceImpl topicsService = new TopicsServiceImpl();
//        ExampleServiceImpl exampleService = new ExampleServiceImpl();
//        
//        List<Examples> examplesList = exampleService.getExampleList(json);
//        List<Examples> finalExampleList = exampleService.getExampleByTipicId(examplesList, 1);
//        
//        System.out.println(finalExampleList.size());
       
//       List<Topic> stringTest = topicsService.findTopicByLanguage(topicsService.getTopics(json), Languages.Java, "Getting ! Java");
//       
//       for(Topic t : stringTest) {
//    	   System.out.println(t.getTitle());
//       }
//       System.out.println(stringTest.size());
        
        

//		List<Topic> listTopic= imockService.getListTopic();
//		listTopic.forEach(s->System.out.println(s.id+s.title+s.answer));
//		
//		List<Examples> listExamples = imockService.getListExample();
//		listExamples.forEach(s->System.out.println(s.id+s.description+s.docTopicId.title+s.docTopicId.docTagId.title));		
    }

}
