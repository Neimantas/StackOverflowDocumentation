package service;

import java.util.List;

import models.enums.Languages;
import models.java_models.DocTags;



public interface DocTagsService {
	List<DocTags> getDocTags(String json);
	DocTags getDocTagsById(String json, long id);
	List<DocTags> getDocTagsByLanguage(Languages languages, List<DocTags> docTags);
}
