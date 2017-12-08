package service;

import java.util.ArrayList;
import java.util.List;

import models.java_models.DocTags;
import models.java_models.DocTagsVersions;
import models.java_models.mock.DocTagsVersionsMock;

public class MockService implements IMockService {

	@Override
	public List<DocTagsVersions> getListObject() {
		// TODO Auto-generated method stub
		List<DocTagsVersionsMock> docTagsVersionsList = new ArrayList();
		for(int i= 1; i<=10; i++) {
			docTagsVersionsList.add(new DocTagsVersionsMock());
		}
		
		List<DocTagsVersions> normalList = new ArrayList();
		for (DocTagsVersionsMock item : docTagsVersionsList) {
			
			DocTagsVersions temp = new DocTagsVersions();
				DocTags tempTags = new DocTags();
				tempTags.id = item.doctagid.id;
				tempTags.title= item.doctagid.title;
			temp.doctagid = tempTags;
			temp.id = item.id;
			temp.title = item.title; 

			normalList.add(temp);
		}
		return normalList;
	}

	@Override
	public List<DocTagsVersions> getListById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocTagsVersions> getListByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
