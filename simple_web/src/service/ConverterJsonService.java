package service;

import java.util.List;

import models.java_models.DocTags;
import models.java_models.DocTagsVersions;
import models.java_models.Examples;
import models.java_models.Topic;

public interface ConverterJsonService {
	public List<Topic> convertTopicsFromJson(String json);
	public List<DocTags> convertTagsFromJson(String json);
	public List<DocTagsVersions> convertDocTagsVersionsFromJson(String json);
	public List<Examples> convertExamplesFromJson(String json);
}
