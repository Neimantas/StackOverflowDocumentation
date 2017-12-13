package testingMain;

import java.io.File;
import java.io.IOException;
import java.util.List;

import models.enums.Languages;
import models.java_models.DocTags;
import models.java_models.DocTagsVersions;
import models.java_models.Topic;
import service.file.FileService;
import service.impl.DocTagsServiceImpl;
import service.impl.TopicsServiceImpl;
import service.mock.IMockService;
import service.mock.impl.MockService;
import service.search.LanguageSearchService;

public class TestingMain {


    public static void main(String[] args) throws IOException {

//		IMockService imockService= new MockService();
//		List<DocTagsVersions> list= imockService.getListObject();
//
//		list.forEach(s->System.out.println(s.id+s.title));

        FileService fileService = new FileService();
        String json = fileService.getFileContent("C:\\Users\\CodeAcademy\\IdeaProjects\\Romas Noreika\\StackOverflowDocumentation\\simple_web\\src\\externalSources\\topics.json");

        TopicsServiceImpl topicsService = new TopicsServiceImpl();
        List<Topic> topics = topicsService.getTopics(json);
        List<Topic> topicByDocTagId = topicsService.findTopicByLanguage(topics, Languages.Java);
        System.out.println(topicByDocTagId.size());
//		List<Topic> listTopic= imockService.getListTopic();
//		listTopic.forEach(s->System.out.println(s.id+s.title+s.answer));
//		
//		List<Examples> listExamples = imockService.getListExample();
//		listExamples.forEach(s->System.out.println(s.id+s.description+s.docTopicId.title+s.docTopicId.docTagId.title));		
    }

}
