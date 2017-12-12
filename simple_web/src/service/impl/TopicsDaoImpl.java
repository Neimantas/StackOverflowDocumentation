package service.impl;

import models.java_models.Topic;
import service.ConverterJsonService;
import service.TopicsDao;

import java.util.List;
import java.util.stream.Collectors;

public class TopicsDaoImpl implements TopicsDao {
	ConverterJsonService conv;
	
public TopicsDaoImpl() {
	conv= new ConverterJsonService();
}
  
    @Override
    public List<Topic> getTopics(String json) {
//    	ConverterJsonService converterJsonService=new ConverterJsonService();
        return conv.convertTopicsFromJson(json);
    }

    
    @Override
    public Topic getTopicById(String json, long id) {
 
        List<Topic> topics = conv.convertTopicsFromJson(json);
        List<Topic> collectedList = topics
                .stream()
                .filter(topic -> topic.getId() == id)
                .collect(Collectors.toList());

        return collectedList.get(0);
    }
}
