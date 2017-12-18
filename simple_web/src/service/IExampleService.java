package service;

import java.util.List;

import models.java_models.Examples;

public interface IExampleService {
	
	List<Examples> getExampleList(String json);
	List<Examples> getExampleByTipicId(List<Examples> exampleList, long topicExampleId);

}
