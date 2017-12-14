package service;

import models.enums.Languages;
import models.java_models.Topic;

import java.util.List;

public interface TopicsService {
    List<Topic> getTopics(String json);

    Topic getTopicById(List<Topic> topics, long id);

    List<Topic> findTopicByLanguage(List<Topic> topics, Languages languages, String keyword);
    List<Topic> getTopicsByPage(List<Topic> listTopic, int start);
   
}
