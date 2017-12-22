package service.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.enums.Languages;
import models.java_models.Topic;
import service.IConverterJsonService;
import service.ITopicsService;

public class TopicsServiceImpl implements ITopicsService {
    IConverterJsonService conv;

	public TopicsServiceImpl() {
        conv = new ConverterJsonServiceImp();
	}

	@Override
	public List<Topic> getTopics(String json) {
		// ConverterJsonService converterJsonService=new ConverterJsonService();
		return conv.convertTopicsFromJson(json);
	}

	@Override
	public Topic getTopicById(List<Topic> topics, long id) {

		List<Topic> collectedList = topics.stream().filter(topic -> topic.getId() == id).collect(Collectors.toList());

		return collectedList.get(0);
	}

	@Override
	public List<Topic> findTopicByLanguage(List<Topic> topics, Languages languages, String keyword) {
		// TODO Auto-generated method stub
		List<String> keywordsList = makeListFromKeyword(keyword);
		if (keyword == "") {
			List<Topic> filterdTopicList = topics.stream().filter(topic -> topic.getDocTagId() == languages.getValue())
					.collect(Collectors.toList());
			return filterdTopicList;
		} else {
			List<Topic> topicsList = new ArrayList<>();
			for (int i = 0; i < keywordsList.size(); i++) {
				String value = keywordsList.get(i);
				List<Topic> collectedList = topics.stream()
						.filter(topic -> topic.getDocTagId() == languages.getValue())
						.filter(topic -> topic.getTitle().toLowerCase().contains(value.toLowerCase()))
						.collect(Collectors.toList());

				for (Topic topic : collectedList) {
					if(!topicsList.contains(topic)) {
					
					topicsList.add(topic);
					}
				}
			}
			return topicsList;
		}
	}

	private List<String> makeListFromKeyword(String keyword) {
		// TODO Auto-generated method stub
		List<String> keywordList = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		String temp = "";
		char[] charArray = keyword.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			char ch = (char) charArray[i];

			if (!Character.isSpaceChar(ch)) {
				builder.append(ch);
				if (i == charArray.length - 1) {
					keywordList.add(builder.toString());
				}
			} else {
				keywordList.add(builder.toString());
				builder.setLength(0);
			}

		}
		for (int i = 0; i < keywordList.size(); i++) {
			String temp2 = keywordList.get(i).replaceAll(",", "");
			keywordList.set(i, temp2);
		}
		return keywordList;
	}

	@Override
	public List<Topic> getTopicsByPage(List<Topic> listTopic, int start) {
		// TODO Auto-generated method stub

		List<Topic> listTopicsByPage = new ArrayList();
		for (int i = start - 1; i <= start + 10; i++) {
			try {
			listTopicsByPage.add(listTopic.get(i));
			} catch (IndexOutOfBoundsException e) {
				break;
			}
		}
		return listTopicsByPage;
	}

}
