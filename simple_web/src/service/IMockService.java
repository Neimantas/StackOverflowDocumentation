package service;

import java.util.List;

import models.java_models.DocTagsVersions;

public interface IMockService {
	List<DocTagsVersions> getListObject();
	List<DocTagsVersions> getListById(int id);
	List<DocTagsVersions> getListByName(String name);
}
