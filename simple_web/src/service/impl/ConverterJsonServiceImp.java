package service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import models.DTO.DTOdocTagVersions;
import models.DTO.DTOdocTags;
import models.DTO.DTOexamples;
import models.DTO.DTOtopics;
import models.java_models.DocTags;
import models.java_models.DocTagsVersions;
import models.java_models.Examples;
import models.java_models.Topic;
import service.IConverterJsonService;
import service.ITimestapConverter;

public class ConverterJsonServiceImp implements IConverterJsonService{
	
	ITimestapConverter converter = new TimestapConverterImp();
	
	@Override
    public List<Topic> convertTopicsFromJson(String json) {
        Gson gson = new Gson();
        DTOtopics[] topicsArray = gson.fromJson(json, DTOtopics[].class);
        List<Topic> topics = convertDTOTopicsToTopic(Arrays.asList(topicsArray));
        return topics;
    }

    private List<Topic> convertDTOTopicsToTopic(List<DTOtopics> dtOtopics) {
    	
        List<Topic> topics = new ArrayList<>();
        for (DTOtopics dtOtopic : dtOtopics) {
            Topic topic = new Topic();
            topic.setId(dtOtopic.getId());
            topic.setDocTagId(dtOtopic.getDocTagId());
            topic.setTitle(dtOtopic.getTitle());
            topic.setAnswer(dtOtopic.getRemarksMarkdown());
            topic.setCreationDate(converter.timestampStringToDate(dtOtopic.getCreationDate()));
            topic.setLastEditDate(converter.timestampStringToDate(dtOtopic.getLastEditDate()));
            topics.add(topic);
        }
        return topics;
    }

    @Override
    public List<DocTags> convertTagsFromJson(String json) {
        Gson gson = new Gson();
        DTOdocTags[] dtOdocTagsArray = gson.fromJson(json, DTOdocTags[].class);
        List<DocTags> tags = convertDTODocTagsToDocTag(Arrays.asList(dtOdocTagsArray));
        return tags;
    }

    private List<DocTags> convertDTODocTagsToDocTag(List<DTOdocTags> docTags) {
        List<DocTags> docTagsList = new ArrayList<>();
        for (DTOdocTags dtOdogTag : docTags) {
            DocTags docTag = new DocTags();
            docTag.setId(dtOdogTag.getId());
            docTag.setTitle(dtOdogTag.getTitle());
            docTag.setCreationDate(converter.timestampStringToDate(dtOdogTag.getCreationDate()));
            docTagsList.add(docTag);
        }
        return docTagsList;
    }
    
    @Override
    public List<DocTagsVersions> convertDocTagsVersionsFromJson(String json) {
        Gson gson = new Gson();
        DTOdocTagVersions[] dtOdocTagVersions = gson.fromJson(json, DTOdocTagVersions[].class);
        List<DocTagsVersions> docTagsVersions = convertDTODocTagsVersionsToDocTagVersion(Arrays.asList(dtOdocTagVersions));
        return docTagsVersions;
    }

    private List<DocTagsVersions> convertDTODocTagsVersionsToDocTagVersion(List<DTOdocTagVersions> dtOdocTagVersions) {
        List<DocTagsVersions> docTagsVersions = new ArrayList<>();
        for (DTOdocTagVersions dtOdocTagVersion : dtOdocTagVersions) {
            DocTagsVersions docTagsVersion = new DocTagsVersions();
            docTagsVersion.setId(dtOdocTagVersion.getId());
            docTagsVersion.setTitle(dtOdocTagVersion.getName());
            docTagsVersion.setDoctagid(dtOdocTagVersion.getDocTagId());
            docTagsVersion.setCreationDate(converter.timestampStringToDate(dtOdocTagVersion.getCreationDate()));
            docTagsVersion.setLastEditDate(converter.timestampStringToDate(dtOdocTagVersion.getLastEditDate()));
            docTagsVersions.add(docTagsVersion);
        }
        return docTagsVersions;
    }

    @Override
    public List<Examples> convertExamplesFromJson(String json) {
        Gson gson = new Gson();
        DTOexamples[] dtOexamples = gson.fromJson(json, DTOexamples[].class);
        List<Examples> examples = convertDTOExamplesToExamples(Arrays.asList(dtOexamples));
        return examples;
    }

    private List<Examples> convertDTOExamplesToExamples(List<DTOexamples> dtOexamples) {
        List<Examples> examplesList = new ArrayList<>();
        for(DTOexamples dtOexample : dtOexamples){
            Examples example = new Examples();
            example.setId(dtOexample.getId());
            example.setTitle(dtOexample.getTitle());
            example.setDescription(dtOexample.getBodyMarkdown());
            example.setDocTopicId(dtOexample.getDocTopicId());
            example.setCreationDate(converter.timestampStringToDate(dtOexample.getCreationDate()));
            example.setLastEditDate(converter.timestampStringToDate(dtOexample.getLastEditDate()));
            examplesList.add(example);
        }
        return examplesList;
    }
}

