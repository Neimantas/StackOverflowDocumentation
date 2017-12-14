package service.impl;

import models.enums.Languages;
import models.java_models.Topic;
import service.converter.ConverterJsonService;
import service.TopicsService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopicsServiceImpl implements TopicsService {
    ConverterJsonService conv;

    public TopicsServiceImpl() {
        conv = new ConverterJsonService();
    }

    @Override
    public List<Topic> getTopics(String json) {
//    	ConverterJsonService converterJsonService=new ConverterJsonService();
        return conv.convertTopicsFromJson(json);
    }


    @Override
    public Topic getTopicById(List<Topic> topics, long id) {

        List<Topic> collectedList = topics
                .stream()
                .filter(topic -> topic.getId() == id)
                .collect(Collectors.toList());

        return collectedList.get(0);
    }

    @Override
    public List<Topic> findTopicByLanguage(List<Topic> topics, Languages languages, String keyword) {
        // TODO Auto-generated method stub
    	if (keyword == "") {
        List<Topic> collectedList = topics
                .stream()
                .filter(topic -> topic.getDocTagId() == languages.getValue())
                .collect(Collectors.toList());
        return collectedList;
    	}
    	else {
    		List<Topic> collectedList = topics
                    .stream()
                    .filter(topic -> topic.getDocTagId() == languages.getValue())
                    .filter(topic -> topic.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
            return collectedList;
    	}
    }
    
    @Override
	public List<Topic> getTopicsByPage(List<Topic> listTopic, int start) {
		// TODO Auto-generated method stub

		List<Topic> listTopicsByPage= new ArrayList();
		for(int i=start-1; i<=start+10; i++) {
			listTopicsByPage.add(listTopic.get(i));
		}
		return listTopicsByPage;
	}

}
