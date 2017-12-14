package testingMain;

import java.io.File;
import java.io.IOException;
import java.util.List;

import models.enums.Languages;
import models.java_models.DocTags;
import models.java_models.DocTagsVersions;
import models.java_models.Topic;
import service.IMockService;
import service.ILanguageSearchService;
import service.impl.DocTagsServiceImpl;
import service.impl.FileServiceImp;
import service.impl.MockService;
import service.impl.TopicsServiceImpl;

public class TestingMain {


    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

//		IMockService imockService= new MockService();
//		List<DocTagsVersions> list= imockService.getListObject();
//
//		list.forEach(s->System.out.println(s.id+s.title));

        FileServiceImp fileService = new FileServiceImp();
        String json = fileService.getFileContent("C:\\Users\\Simas\\Documents\\StackOverflowDocumentation\\simple_web\\src\\externalSources\\topics.json");

        TopicsServiceImpl topicsService = new TopicsServiceImpl();
        
       
       List<Topic> stringTest = topicsService.findTopicByLanguage(topicsService.getTopics(json), Languages.Java, "Getting ! Java");
       
       for(Topic t : stringTest) {
    	   System.out.println(t.getTitle());
       }
//       System.out.println(stringTest.size());
        
        

//		List<Topic> listTopic= imockService.getListTopic();
//		listTopic.forEach(s->System.out.println(s.id+s.title+s.answer));
//		
//		List<Examples> listExamples = imockService.getListExample();
//		listExamples.forEach(s->System.out.println(s.id+s.description+s.docTopicId.title+s.docTopicId.docTagId.title));		
    }

}
