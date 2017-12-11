package service;

import java.util.List;

import models.java_models.DocTagsVersions;
import models.java_models.Examples;
import models.java_models.Topic;

public interface IMockService {
	public List<DocTagsVersions> getListObject();
	public List<Topic> getListTopic();
	public List<Examples> getListExample();
	
	public List<DocTagsVersions> getListById(int id);
	public List<DocTagsVersions> getListByName(String name);
}
