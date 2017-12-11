package service.impl;

import models.java_models.Topic;
import service.ConverterJsonService;
import service.TopicsDao;

import java.util.List;
import java.util.stream.Collectors;

public class TopicsDaoImpl implements TopicsDao {

    private ConverterJsonService converterJsonService;

    public TopicsDaoImpl(ConverterJsonService converterJsonService) {
        this.converterJsonService = converterJsonService;
    }

    public TopicsDaoImpl() {
    }


    @Override
    public List<Topic> getTopics(String json) {
        return converterJsonService.convertTopicsFromJson(json);
    }

    @Override
    public Topic getTopicById(String json, long id) {
        List<Topic> topics = converterJsonService.convertTopicsFromJson(json);
        List<Topic> collectedList = topics
                .stream()
                .filter(topic -> topic.getId() == id)
                .collect(Collectors.toList());

        return collectedList.get(0);
    }
}
