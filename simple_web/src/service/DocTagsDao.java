package service;

import java.util.List;

import models.java_models.DocTags;



public interface DocTagsDao {
	List<DocTags> getDocTags(String json);
	DocTags getDocTagsById(String json, long id);
}
