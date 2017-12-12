package service.impl;

import java.util.List;

import models.java_models.DocTags;
import service.ConverterJsonService;
import service.DocTagsDao;

public class DocTagsDaoImpl implements DocTagsDao{

	ConverterJsonService converterJsonService;
	
	
	public DocTagsDaoImpl() {
	converterJsonService = new ConverterJsonService();
	}

	@Override
	public List<DocTags> getDocTags(String json) {
		// TODO Auto-generated method stub
		List<DocTags> docTagsList = converterJsonService.convertTagsFromJson(json);
		return docTagsList;
	}

	@Override
	public DocTags getDocTagsById(String json, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
