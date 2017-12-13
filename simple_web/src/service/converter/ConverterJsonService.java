package service.converter;

import java.util.*;

import models.DTO.DTOdocTagVersions;
import models.DTO.DTOdocTags;
import models.DTO.DTOexamples;
import models.DTO.DTOtopics;
import com.google.gson.*;
import models.java_models.DocTags;
import models.java_models.DocTagsVersions;
import models.java_models.Examples;
import models.java_models.Topic;

public class ConverterJsonService {
	
	
    public List<Topic> convertTopicsFromJson(String json) {
        Gson gson = new Gson();
        DTOtopics[] topicsArray = gson.fromJson(json, DTOtopics[].class);
        List<Topic> topics = convertDTOTopicsToTopic(Arrays.asList(topicsArray));
        return topics;
    }

    private List<Topic> convertDTOTopicsToTopic(List<DTOtopics> dtOtopics) {
    	TimestapConverter converter = new TimestapConverter();
        List<Topic> topics = new ArrayList<>();
        for (DTOtopics dtOtopic : dtOtopics) {
            Topic topic = new Topic();
            topic.setId(dtOtopic.getId());
            topic.setDocTagId(dtOtopic.getDocTagId());
            topic.setTitle(dtOtopic.getTitle());
            topic.setAnswer(dtOtopic.getRemarksMarkdown());
            System.out.println(dtOtopic.getCreationDate());
            topic.setCreationDate(converter.timestampStringToDate(dtOtopic.getCreationDate()));
            topic.setLastEditDate(converter.timestampStringToDate(dtOtopic.getLastEditDate()));
            topics.add(topic);
        }
        return topics;
    }


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
            docTagsList.add(docTag);
        }
        return docTagsList;
    }

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
            docTagsVersions.add(docTagsVersion);
        }
        return docTagsVersions;
    }


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
            examplesList.add(example);
        }
        return examplesList;
    }
}

