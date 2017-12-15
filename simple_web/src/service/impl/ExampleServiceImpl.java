package service.impl;

import java.util.List;
import java.util.stream.Collectors;

import models.java_models.Examples;
import service.IConverterJsonService;
import service.IExampleService;

public class ExampleServiceImpl implements IExampleService {
	IConverterJsonService conv;

	public ExampleServiceImpl() {
        conv = new ConverterJsonServiceImp();
	}

	@Override
	public List<Examples> getExampleList(String json) {
		// TODO Auto-generated method stub
		List<Examples> exampleList = conv.convertExamplesFromJson(json);
		return exampleList;
	}

	@Override
	public List<Examples> getExampleByTipicId(List<Examples> exampleList, long topicId) {
		// TODO Auto-generated method stub
		List <Examples> collectedList = exampleList
				.stream()
				.filter(example -> example.getDocTopicId() == topicId)
				.collect(Collectors.toList());
		return collectedList;
	}

}
