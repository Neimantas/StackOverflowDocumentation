package service.impl;

import models.java_models.Topic;
import service.IAnswerService;

public class AnswerServiceImpl implements IAnswerService {
    @Override
    public String getAnswerFromTopic(Topic topic) {
        return topic.getAnswer();
    }
}
