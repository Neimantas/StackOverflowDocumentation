package service.impl;

import models.java_models.Topic;
import service.AnswerService;

public class AnswerServiceImpl implements AnswerService {
    @Override
    public String getAnswerFromTopic(Topic topic) {
        return topic.getAnswer();
    }
}
