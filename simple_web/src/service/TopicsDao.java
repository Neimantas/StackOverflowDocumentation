package service;

import models.java_models.Topic;

import java.util.List;

public interface TopicsDao {
    List<Topic> getTopics(String json);
    Topic getTopicById(String json, long id);
    List<Topic> findTopicByDocTagId(String json, long docTagId);
}
