package service;

import java.util.List;

import models.java_models.DocTags;
import models.java_models.DocTagsVersions;
import models.java_models.Examples;
import models.java_models.Topic;

public interface IJsonToDatabase {
	public void topicToDB (List<Topic> topicList);
	public void examplesToDB (List<Examples> examplesList);
	public void docTagsToDB (List<DocTags> docTagsList);
	public void docTagsVersions(List<DocTagsVersions> docTagsVersionsList);
}
