package service.impl;

import java.util.List;
import java.util.stream.Collectors;

import models.enums.Languages;
import models.java_models.DocTags;
import service.converter.ConverterJsonService;
import service.DocTagsService;

public class DocTagsServiceImpl implements DocTagsService {

	ConverterJsonService converterJsonService;
	
	
	public DocTagsServiceImpl() {
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

	@Override
	public List<DocTags> getDocTagsByLanguage(Languages languages, List<DocTags> docTags) {
		return docTags
				.stream()
				.filter(docTag -> docTag.getId() == languages.getValue())
				.collect(Collectors.toList());
	}

}
